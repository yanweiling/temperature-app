package com.windsound.project.controller;

import com.windsound.project.common.AjaxResult;
import com.windsound.project.controller.base.BaseController;
import com.windsound.project.entity.Group;
import com.windsound.project.service.IGroupService;
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
 * 机构 信息操作处理
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Controller
@RequestMapping("/generator/group")
public class GroupController extends BaseController
{
	@Autowired
	private IGroupService groupService;

	/**
	 * 查询机构列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public  List<Group> list(Group group)
	{
        List<Group> list = groupService.selectGroupList(group);
	    return list;
	}

	/**
	 * 新增保存机构
	 */
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Group group)
	{		
		return toAjax(groupService.insertGroup(group));
	}

	/**
	 * 修改机构
	 */
	@GetMapping("/edit/{id}")
	public Group edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Group group = groupService.selectGroupById(id);
		return group;
	}
	
	/**
	 * 修改保存机构
	 */
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Group group)
	{		
		return toAjax(groupService.updateGroup(group));
	}

}
