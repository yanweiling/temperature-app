package com.windsound.project.controller;


import com.windsound.project.common.AjaxResult;
import com.windsound.project.controller.base.BaseController;
import com.windsound.project.entity.AdminGroup;
import com.windsound.project.service.IAdminGroupService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 管理员机构关联 信息操作处理
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Controller
@RequestMapping("/generator/adminGroup")
public class AdminGroupController extends BaseController
{
	
	@Autowired
	private IAdminGroupService adminGroupService;

	/**
	 * 查询管理员机构关联列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<AdminGroup> list(AdminGroup adminGroup)
	{
        List<AdminGroup> list = adminGroupService.selectAdminGroupList(adminGroup);
        return list;
	}
	

	/**
	 * 新增保存管理员机构关联
	 */
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AdminGroup adminGroup)
	{		
		return toAjax(adminGroupService.insertAdminGroup(adminGroup));
	}

	/**
	 * 修改管理员机构关联
	 */
	@GetMapping("/edit/{id}")
	@ResponseBody
	public AdminGroup edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		AdminGroup adminGroup = adminGroupService.selectAdminGroupById(id);
		return adminGroup;
	}
	
	/**
	 * 修改保存管理员机构关联
	 */
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AdminGroup adminGroup)
	{		
		return toAjax(adminGroupService.updateAdminGroup(adminGroup));
	}

}
