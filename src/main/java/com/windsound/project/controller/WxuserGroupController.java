package com.windsound.project.controller;

import com.windsound.project.common.AjaxResult;
import com.windsound.project.controller.base.BaseController;
import com.windsound.project.entity.WxuserGroup;
import com.windsound.project.service.IWxuserGroupService;
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
 * 微信用户机构关联 信息操作处理
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Controller
@RequestMapping("/generator/wxuserGroup")
public class WxuserGroupController extends BaseController
{

	@Autowired
	private IWxuserGroupService wxuserGroupService;

	/**
	 * 查询微信用户机构关联列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<WxuserGroup> list(WxuserGroup wxuserGroup)
	{
        List<WxuserGroup> list = wxuserGroupService.selectWxuserGroupList(wxuserGroup);
        return list;
	}

	
	/**
	 * 新增保存微信用户机构关联
	 */
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(WxuserGroup wxuserGroup)
	{		
		return toAjax(wxuserGroupService.insertWxuserGroup(wxuserGroup));
	}

	/**
	 * 修改微信用户机构关联
	 */
	@GetMapping("/edit/{id}")
	@ResponseBody
	public WxuserGroup edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		WxuserGroup wxuserGroup = wxuserGroupService.selectWxuserGroupById(id);
	    return wxuserGroup;
	}
	
	/**
	 * 修改保存微信用户机构关联
	 */
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(WxuserGroup wxuserGroup)
	{		
		return toAjax(wxuserGroupService.updateWxuserGroup(wxuserGroup));
	}

}
