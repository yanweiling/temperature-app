package com.windsound.project.controller;

import com.windsound.project.common.AjaxResult;
import com.windsound.project.controller.base.BaseController;
import com.windsound.project.entity.User;
import com.windsound.project.entity.Userinfo;
import com.windsound.project.service.IUserinfoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
	private IUserinfoService userinfoService;
	
	/**
	 * 查询用户列表
	 */
	@GetMapping("/list")
	@ResponseBody
	public List<Userinfo> list(Userinfo userinfo)
	{
        List<Userinfo> list = userinfoService.selectUserinfoList(userinfo);
		return list;
	}

	/**
	 * 新增保存用户
	 */

	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestBody  Userinfo userinfo)
	{		
		return toAjax(userinfoService.insertUserinfo(userinfo));
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

}
