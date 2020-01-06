package com.windsound.project.service;

import com.windsound.project.entity.User;

import java.util.List;

/**
 * 微信用户 服务层
 * 
 * @author admin
 * @date 2019-12-30
 */
public interface IUserService 
{
	/**
     * 查询微信用户信息
     * 
     * @param id 微信用户ID
     * @return 微信用户信息
     */
	public User selectUserById(String id);
	
	/**
     * 查询微信用户列表
     * 
     * @param user 微信用户信息
     * @return 微信用户集合
     */
	public List<User> selectUserList(User user);
	
	/**
     * 新增微信用户
     * 
     * @param user 微信用户信息
     * @return 结果
     */
	public int insertUser(User user);
	
	/**
     * 修改微信用户
     * 
     * @param user 微信用户信息
     * @return 结果
     */
	public int updateUser(User user);

	
}
