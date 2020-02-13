package com.windsound.project.controller;

import java.util.List;

import com.windsound.project.common.AjaxResult;
import com.windsound.project.controller.base.BaseController;
import com.windsound.project.entity.User;
import com.windsound.project.service.IUserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 微信用户 信息操作处理
 * 
 * @author admin
 * @date 2019-12-30
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController
{
    private String prefix = "module/user";
	
	@Autowired
	private IUserService userService;

	@GetMapping()
	@ResponseBody
	public String user()
	{
	    return prefix + "/user";
	}
	
	/**
	 * 查询微信用户列表
	 */
	@GetMapping("/getUser/{userId}")
	@ResponseBody
	public String list(@PathVariable String userId)
	{
       User user=userService.selectUserById(userId);
       return user.toString();
	}
	




	
}
