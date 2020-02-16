package com.windsound.project.mapper;

import com.windsound.project.entity.WxuserGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 微信用户机构关联 数据层
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Repository
public interface WxuserGroupMapper 
{
	/**
     * 查询微信用户机构关联信息
     * 
     * @param id 微信用户机构关联ID
     * @return 微信用户机构关联信息
     */
	public WxuserGroup selectWxuserGroupById(Long id);
	
	/**
     * 查询微信用户机构关联列表
     * 
     * @param wxuserGroup 微信用户机构关联信息
     * @return 微信用户机构关联集合
     */
	public List<WxuserGroup> selectWxuserGroupList(WxuserGroup wxuserGroup);
	
	/**
     * 新增微信用户机构关联
     * 
     * @param wxuserGroup 微信用户机构关联信息
     * @return 结果
     */
	public int insertWxuserGroup(WxuserGroup wxuserGroup);
	
	/**
     * 修改微信用户机构关联
     * 
     * @param wxuserGroup 微信用户机构关联信息
     * @return 结果
     */
	public int updateWxuserGroup(WxuserGroup wxuserGroup);
	
	/**
     * 删除微信用户机构关联
     * 
     * @param id 微信用户机构关联ID
     * @return 结果
     */
	public int deleteWxuserGroupById(Long id);
	
	/**
     * 批量删除微信用户机构关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWxuserGroupByIds(String[] ids);
	
}