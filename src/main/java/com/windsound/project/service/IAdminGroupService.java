package com.windsound.project.service;

import com.windsound.project.entity.AdminGroup;

import java.util.List;

/**
 * 管理员机构关联 服务层
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
public interface IAdminGroupService 
{
	/**
     * 查询管理员机构关联信息
     * 
     * @param id 管理员机构关联ID
     * @return 管理员机构关联信息
     */
	public AdminGroup selectAdminGroupById(Long id);
	
	/**
     * 查询管理员机构关联列表
     * 
     * @param adminGroup 管理员机构关联信息
     * @return 管理员机构关联集合
     */
	public List<AdminGroup> selectAdminGroupList(AdminGroup adminGroup);
	
	/**
     * 新增管理员机构关联
     * 
     * @param adminGroup 管理员机构关联信息
     * @return 结果
     */
	public int insertAdminGroup(AdminGroup adminGroup);
	
	/**
     * 修改管理员机构关联
     * 
     * @param adminGroup 管理员机构关联信息
     * @return 结果
     */
	public int updateAdminGroup(AdminGroup adminGroup);

	
}
