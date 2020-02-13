package com.windsound.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.windsound.project.common.AjaxResult;
import com.windsound.project.common.DateUtils;
import com.windsound.project.controller.base.BaseController;
import com.windsound.project.entity.User;
import com.windsound.project.entity.Userinfo;
import com.windsound.project.entity.Wxuser;
import com.windsound.project.entity.po.UserPO;
import com.windsound.project.service.IUserinfoService;
import com.windsound.project.service.IWxuserService;
import com.windsound.project.service.impl.UserinfoServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.PushbackReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 用户 信息操作处理
 * 
 * @author yanwlb
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/userinfo")
public class UserinfoController extends BaseController
{
	
	@Autowired
	UserinfoServiceImpl userinfoService;

	@Autowired
	IWxuserService wxuserService;

	/**
	 * 查询用户列表
	 */
	@GetMapping("/list")
	@ResponseBody
	public List<Userinfo> list(@RequestBody(required = false)  Userinfo userinfo)
	{
        List<Userinfo> list = userinfoService.selectUserinfoList(userinfo);
		return list;
	}

	/**
	 * 新增保存用户
	 */

	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestBody UserPO userPO)
	{		
        //根据openId获得用户
		if(StringUtils.isEmpty(userPO.getOpenId())){
			return AjaxResult.error("请传入用户openId");
		}
		if(StringUtils.isEmpty(userPO.getUserName())){
			return AjaxResult.error("请输入用户名称");
		}
		if(StringUtils.isEmpty(userPO.getIdCard())){
			return AjaxResult.error("请输入身份证号");
		}
		if(StringUtils.isEmpty(userPO.getTel())){
			return AjaxResult.error("请输入手机号");
		}

		if(userPO.getUserinfo()==null || Userinfo.isAllEmpty(userPO.getUserinfo())){
			return AjaxResult.error("请补充您的健康信息");
		}
		AjaxResult result=userinfoService.insertUserPo(userPO);
        return result;

	}

	/**
	 * 修改用户
	 */
	@GetMapping("/edit/{id}")
	@ResponseBody
	public Userinfo edit(@PathVariable("id") Long id)
	{
		Userinfo userinfo = userinfoService.selectUserinfoById(id);
		return userinfo;
	}
	
	/**
	 * 修改保存用户
	 */
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@RequestBody  Userinfo userinfo)
	{		
		return toAjax(userinfoService.updateUserinfo(userinfo));
	}


	public static void main(String[] args) {
		UserPO userPO=new UserPO();
		userPO.setOpenId("oadnu0Gkw7XemE5yyyDpf8-pZo4U");
		userPO.setIdCard("130729198702242589");
		userPO.setTel("15932451245");
		userPO.setUserName("刘新洲");

		Userinfo userinfo=new Userinfo();
		userinfo.setIsDuty(1);
		userinfo.setTemperature(new BigDecimal(37.0));
		userinfo.setAddress("张家口柴沟堡");
		userinfo.setCurrAddress("张家口市桥东区");
		userinfo.setIsSelfFeverCough(0);
		userinfo.setIsSelfPassWuhan(0);
		userinfo.setIsSelfTouchHubei(0);
		userinfo.setIsSelfTouchWenzhou(0);
		userinfo.setIsOtherFeverCough(0);
		userinfo.setIsOtherTouchHubei(0);
		userinfo.setIsOtherPassWuhan(0);
		userinfo.setIsOtherTouchWenzhou(0);
		userinfo.setRemark("轻微感冒");
		userPO.setUserinfo(userinfo);
		String json= JSON.toJSONString(userPO);
		System.out.println(json);

	}
}
