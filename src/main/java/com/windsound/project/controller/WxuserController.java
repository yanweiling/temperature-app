package com.windsound.project.controller;

import com.windsound.project.common.AjaxResult;
import com.windsound.project.controller.base.BaseController;
import com.windsound.project.entity.Wxuser;
import com.windsound.project.service.IWxuserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.java.Log;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	@Autowired
	private IWxuserService wxuserService;

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
