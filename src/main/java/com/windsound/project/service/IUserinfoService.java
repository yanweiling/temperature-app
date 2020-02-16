package com.windsound.project.service;

import com.windsound.project.entity.Userinfo;
import com.windsound.project.entity.vo.UserVo;

import java.util.List;
import java.util.Map;

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

	public List<Userinfo> selectUserinfo(Userinfo userinfo);

	public List<UserVo> selectUserVoList(UserVo userVo);

	public List<UserVo> selectUserVoList(Map<String,Object> param);

	public Integer selectCount(Map<String,Object> param);
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
