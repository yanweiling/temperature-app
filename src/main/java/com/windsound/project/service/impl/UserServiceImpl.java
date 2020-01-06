package com.windsound.project.service.impl;

import java.util.List;
import com.windsound.project.entity.User;
import com.windsound.project.mapper.UserMapper;
import com.windsound.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信用户 服务层实现
 * 
 * @author admin
 * @date 2019-12-30
 */
@Service
public class UserServiceImpl implements IUserService
{
	@Autowired
	private UserMapper userMapper;

	/**
     * 查询微信用户信息
     * 
     * @param id 微信用户ID
     * @return 微信用户信息
     */
    @Override
	public User selectUserById(String id)
	{
	    return userMapper.selectUserById(id);
	}
	
	/**
     * 查询微信用户列表
     * 
     * @param user 微信用户信息
     * @return 微信用户集合
     */
	@Override
	public List<User> selectUserList(User user)
	{
	    return userMapper.selectUserList(user);
	}
	
    /**
     * 新增微信用户
     * 
     * @param user 微信用户信息
     * @return 结果
     */
	@Override
	public int insertUser(User user)
	{
	    return userMapper.insertUser(user);
	}
	
	/**
     * 修改微信用户
     * 
     * @param user 微信用户信息
     * @return 结果
     */
	@Override
	public int updateUser(User user)
	{
	    return userMapper.updateUser(user);
	}

}
