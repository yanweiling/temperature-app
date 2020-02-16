package com.windsound.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.windsound.project.common.AjaxResult;
import com.windsound.project.entity.Group;
import com.windsound.project.entity.Wxuser;
import com.windsound.project.entity.WxuserGroup;
import com.windsound.project.service.IGroupService;
import com.windsound.project.service.IWxuserGroupService;
import com.windsound.project.service.IWxuserService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Controller
@RequestMapping("/authorize")
public class AuthorizeController {
    private static Logger log= LoggerFactory.getLogger(AuthorizeController.class);
    private static  String URL="https://api.weixin.qq.com/sns/jscode2session?";
    private static final String APPID="wx0c3e8f4243fd7cf0";
    private static final String SECRET="170bcae3c7a971ab914b599f608d8406";
    private static final String GRANT_TYPE="authorization_code";

    @Autowired
    IWxuserService wxuserService;
    @Autowired
    IWxuserGroupService wxuserGroupService;

    @Autowired
    IGroupService groupService;
    @PostMapping("/code2Session")
    @ResponseBody
    public  AjaxResult code2Session(@RequestParam String jsCode){
        try{
            RestTemplate restTemplate=new RestTemplate();
            StringBuffer params=new StringBuffer();
            params.append("appid=").append(APPID).append("&");
            params.append("secret=").append(SECRET).append("&");
            params.append("grant_type=").append(GRANT_TYPE).append("&");
            params.append("js_code=").append(jsCode);
            String localURL=URL+params.toString();
            log.info(localURL);

            ResponseEntity<String> responseEntity=restTemplate.getForEntity(localURL, String.class);
            if(responseEntity.getStatusCode()!= HttpStatus.OK){
                return AjaxResult.error("微信授权失败");
            }
            log.info(responseEntity.getBody().toString());
            String openId=JSONObject.parseObject(responseEntity.getBody()).getString("openid");
            if(!StringUtils.isEmpty(openId)){
                Wxuser wxuser=new Wxuser();
                wxuser.setOpenId(openId);
                List<Wxuser> list = wxuserService.selectWxuserList(wxuser);
                if(CollectionUtils.isEmpty(list)){
                    wxuserService.insertWxuser(wxuser);
                    log.info("用户成功保存到数据库");
                    AjaxResult result= AjaxResult.success();
                    result.put("msg","授权成功");
                    result.put("openid",openId);
                    return result;
                }else{
                    Long wxuserId=list.get(0).getId();
                    //获取关联的机构id
                    WxuserGroup wxuserGroup=new WxuserGroup();
                    wxuserGroup.setWxuserId(wxuserId);
                    List<WxuserGroup> wxuserGroups=wxuserGroupService.selectWxuserGroupList(wxuserGroup);
                    AjaxResult result= AjaxResult.success();
                    result.put("msg","授权成功");
                    result.put("openid",openId);
                    if(!CollectionUtils.isEmpty(wxuserGroups)){
                        Long groupId=wxuserGroups.get(0).getGroupId();
                        Group group=groupService.selectGroupById(groupId);
                        result.put("groupInfo",group);
                    }
                    return result;
                }
            }else{
                log.warn("该jsCode已经使用过了");
                return AjaxResult.error("该jsCode已经使用过了");
            }
        }catch (Exception e){
            log.error("授权接口发生异常",e);
            return AjaxResult.error("授权接口发生异常");
        }
    }

}
