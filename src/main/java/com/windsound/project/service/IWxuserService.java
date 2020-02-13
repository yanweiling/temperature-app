package com.windsound.project.service;

import com.windsound.project.entity.Wxuser;

import java.util.List;

/**
 * 微信用户 服务层
 * 
 * @author yanwlb
 * @date 2020-02-13
 */
public interface IWxuserService 
{
	/**
     * 查询微信用户信息
     * 
     * @param id 微信用户ID
     * @return 微信用户信息
     */
	public Wxuser selectWxuserById(Long id);
	
	/**
     * 查询微信用户列表
     * 
     * @param wxuser 微信用户信息
     * @return 微信用户集合
     */
	public List<Wxuser> selectWxuserList(Wxuser wxuser);
	
	/**
     * 新增微信用户
     * 
     * @param wxuser 微信用户信息
     * @return 结果
     */
	public int insertWxuser(Wxuser wxuser);
	
	/**
     * 修改微信用户
     * 
     * @param wxuser 微信用户信息
     * @return 结果
     */
	public int updateWxuser(Wxuser wxuser);

	
}
