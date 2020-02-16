package com.windsound.project.controller;

import java.util.List;

import com.windsound.project.common.AjaxResult;
import com.windsound.project.controller.base.BaseController;
import com.windsound.project.entity.Admin;
import com.windsound.project.entity.AdminGroup;
import com.windsound.project.entity.Group;
import com.windsound.project.entity.po.AdminGroupPO;
import com.windsound.project.service.IAdminGroupService;
import com.windsound.project.service.IAdminService;
import com.windsound.project.service.IGroupService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


/**
 * 管理员 信息操作处理
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController extends BaseController
{

	@Autowired
	private IAdminService adminService;
	@Autowired
	private IAdminGroupService adminGroupService;
	@Autowired
	private IGroupService groupService;

	@PostMapping("/login")
	@ResponseBody
	public AjaxResult login(@RequestBody  AdminGroupPO adminGroupPO){
		try{
			if(StringUtils.isEmpty(adminGroupPO.getLoginName()))
				return AjaxResult.error("请填写登录用户名");
			if(StringUtils.isEmpty(adminGroupPO.getLoginPwd()))
				return AjaxResult.error("请填写用户密码");
			//校验用户
			Admin admin=new Admin();
			admin.setLoginName(adminGroupPO.getLoginName());
			admin.setLoginPwd(adminGroupPO.getLoginPwd());
			Admin adminDB=adminService.selectAdmin(admin);
			if(adminDB==null)
				return AjaxResult.error("用户名或密码不正确");
			AdminGroupPO result=new AdminGroupPO();
			result.setLoginName(adminGroupPO.getLoginName());
			//获取管理人员所在的单位
			AdminGroup adminGroup=new AdminGroup();
			adminGroup.setAdminId(adminDB.getId());
			List<AdminGroup> adminGroups=adminGroupService.selectAdminGroupList(adminGroup);
			if(!CollectionUtils.isEmpty(adminGroups)){
				Long groupId=adminGroups.get(0).getGroupId();
				Group group=groupService.selectGroupById(groupId);
				result.setGroupName(group.getGroupName());
			}
			AjaxResult ret= AjaxResult.success("登录成功");
			ret.put("loginInfo",result);
			return ret;
		}catch (Exception e){
			log.error("登录失败",e);
			return AjaxResult.error("登录失败");
		}
	}


	/**
	 * 注册管理员
	 */
	@PostMapping("/register")
	@ResponseBody
	public AjaxResult register(@RequestBody  AdminGroupPO adminGroupPO)
	{
		try{
			if(StringUtils.isEmpty(adminGroupPO.getLoginName()))
				return AjaxResult.error("请填写登录用户名");
			if(StringUtils.isEmpty(adminGroupPO.getLoginPwd()))
				return AjaxResult.error("请填写用户密码");
			if(StringUtils.isEmpty(adminGroupPO.getGroupName()))
				return AjaxResult.error("请填写所在单位、机构名称");
			//校验管理员是否已经存在
			Admin admin=new Admin();
			admin.setLoginName(adminGroupPO.getLoginName());
			Admin adminEntity=adminService.selectAdmin(admin);
			if(adminEntity!=null){
				return AjaxResult.error("此登录账号已经存在，请输入其他登录账号");
			}
			//注册
			adminService.registerAdminAndGroup(adminGroupPO);
			return AjaxResult.success("创建成功");
		}catch (Exception e){
			log.error("创建管理员失败",e);
			return AjaxResult.error("创建管理员失败");
		}
	}
	/**
	 * 查询管理员列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<Admin> list(Admin admin)
	{
        List<Admin> list = adminService.selectAdminList(admin);
		return list;
	}

	/**
	 * 新增保存管理员
	 */
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Admin admin)
	{		
		return toAjax(adminService.insertAdmin(admin));
	}

	/**
	 * 修改管理员
	 */
	@GetMapping("/edit/{id}")
	@ResponseBody
	public Admin edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Admin admin = adminService.selectAdminById(id);
		return admin;
	}
	
	/**
	 * 修改保存管理员
	 */
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Admin admin)
	{		
		return toAjax(adminService.updateAdmin(admin));
	}

	
}
