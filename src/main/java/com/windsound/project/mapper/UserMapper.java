package com.windsound.project.mapper;

import com.windsound.project.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 微信用户 数据层
 * 
 * @author admin
 * @date 2019-12-30
 */
@Repository
public interface UserMapper 
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
	
	/**
     * 删除微信用户
     * 
     * @param id 微信用户ID
     * @return 结果
     */
	public int deleteUserById(String id);
	
	/**
     * 批量删除微信用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserByIds(String[] ids);
	
}