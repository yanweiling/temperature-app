package com.windsound.project.mapper;

import com.windsound.project.entity.Userinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户 数据层
 * 
 * @author yanwlb
 * @date 2020-02-13
 */
@Repository
public interface UserinfoMapper 
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
	
	/**
     * 删除用户
     * 
     * @param id 用户ID
     * @return 结果
     */
	public int deleteUserinfoById(Long id);
	
	/**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserinfoByIds(String[] ids);
	
}