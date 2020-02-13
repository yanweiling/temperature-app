package com.windsound.project.service.impl;

import java.util.List;

import com.windsound.project.entity.Userinfo;
import com.windsound.project.mapper.UserinfoMapper;
import com.windsound.project.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 用户 服务层实现
 * 
 * @author yanwlb
 * @date 2020-02-13
 */
@Service
public class UserinfoServiceImpl implements IUserinfoService
{
	@Autowired
	private UserinfoMapper userinfoMapper;

	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
	public Userinfo selectUserinfoById(Long id)
	{
	    return userinfoMapper.selectUserinfoById(id);
	}
	
	/**
     * 查询用户列表
     * 
     * @param userinfo 用户信息
     * @return 用户集合
     */
	@Override
	public List<Userinfo> selectUserinfoList(Userinfo userinfo)
	{
	    return userinfoMapper.selectUserinfoList(userinfo);
	}
	
    /**
     * 新增用户
     * 
     * @param userinfo 用户信息
     * @return 结果
     */
	@Override
	public int insertUserinfo(Userinfo userinfo)
	{
	    return userinfoMapper.insertUserinfo(userinfo);
	}
	
	/**
     * 修改用户
     * 
     * @param userinfo 用户信息
     * @return 结果
     */
	@Override
	public int updateUserinfo(Userinfo userinfo)
	{
	    return userinfoMapper.updateUserinfo(userinfo);
	}


	
}
