package com.windsound.project.controller;

import com.windsound.project.common.AjaxResult;
import com.windsound.project.common.DateUtils;
import com.windsound.project.controller.base.BaseController;
import com.windsound.project.entity.Userinfo;
import com.windsound.project.entity.Wxuser;
import com.windsound.project.service.IUserinfoService;
import com.windsound.project.service.IWxuserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.java.Log;
import netscape.javascript.JSObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信用户 信息操作处理
 * 
 * @author yanwlb
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/wxuser")
public class WxuserController extends BaseController
{
	private static Logger log= LoggerFactory.getLogger(WxuserController.class);
	@Autowired
	private IWxuserService wxuserService;

	@Autowired
	private IUserinfoService userinfoService;

	/**
	 * 查询微信用户列表
	 */
	@GetMapping("/list")
	@ResponseBody
	public List<Wxuser> list(@RequestBody(required = false) Wxuser wxuser)
	{
        List<Wxuser> list = wxuserService.selectWxuserList(wxuser);
		return list;
	}
	@GetMapping("/info")
	@ResponseBody
	public AjaxResult getWxuser(@RequestParam String openId){
		try{
			Wxuser wxuser=new Wxuser();
			wxuser.setOpenId(openId);
			List<Wxuser> list = wxuserService.selectWxuserList(wxuser);
			if(CollectionUtils.isEmpty(list)){
				return AjaxResult.error("此用户还没有登录过此程序");
			}
			Wxuser user=list.get(0);
			Long wxuserId=user.getId();
			String today= DateUtils.getDate();
			Userinfo userinfo=new Userinfo();
			userinfo.setWxid(wxuserId);
			userinfo.setUploadTime(today);
			List<Userinfo> userinfos=userinfoService.selectUserinfoList(userinfo);
			AjaxResult result= AjaxResult.success();
			result.put("user",user);
			if(!CollectionUtils.isEmpty(userinfos)){
				result.put("healthinfo",userinfos.get(0));
			}
			return result;
		}catch (Exception e){
			log.error("获取用户信息发生异常",e);
			return AjaxResult.error("获取信息失败");
		}

	}

	/**
	 * 新增保存微信用户
	 */
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestBody  Wxuser wxuser)
	{		
		return toAjax(wxuserService.insertWxuser(wxuser));
	}

	/**
	 * 修改微信用户
	 */
	@GetMapping("/edit/{id}")
	@ResponseBody
	public Wxuser edit(@PathVariable("id") Long id)
	{
		Wxuser wxuser = wxuserService.selectWxuserById(id);
	    return wxuser;
	}
	
	/**
	 * 修改保存微信用户
	 */
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@RequestBody Wxuser wxuser)
	{		
		return toAjax(wxuserService.updateWxuser(wxuser));
	}

}
