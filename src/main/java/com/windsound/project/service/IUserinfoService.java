package com.windsound.project.service;

import com.windsound.project.entity.Userinfo;

import java.util.List;

/**
 * 用户 服务层
 * 
 * @author yanwlb
 * @date 2020-02-13
 */
public interface IUserinfoService 
{
	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
	public Userinfo selectUserinfoById(Long id);
	
	/**
     * 查询用户列表
     * 
     * @param userinfo 用户信息
     * @return 用户集合
     */
	public List<Userinfo> selectUserinfoList(Userinfo userinfo);
	
	/**
     * 新增用户
     * 
     * @param userinfo 用户信息
     * @return 结果
     */
	public int insertUserinfo(Userinfo userinfo);
	
	/**
     * 修改用户
     * 
     * @param userinfo 用户信息
     * @return 结果
     */
	public int updateUserinfo(Userinfo userinfo);

	
}
