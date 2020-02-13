package com.windsound.project.mapper;

import com.windsound.project.entity.Wxuser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 微信用户 数据层
 * 
 * @author yanwlb
 * @date 2020-02-13
 */
@Repository
public interface WxuserMapper 
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
	
	/**
     * 删除微信用户
     * 
     * @param id 微信用户ID
     * @return 结果
     */
	public int deleteWxuserById(Long id);
	
	/**
     * 批量删除微信用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWxuserByIds(String[] ids);
	
}