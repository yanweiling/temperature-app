package com.windsound.project.mapper;

import com.windsound.project.entity.AdminGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员机构关联 数据层
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Repository
public interface AdminGroupMapper 
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
	
	/**
     * 删除管理员机构关联
     * 
     * @param id 管理员机构关联ID
     * @return 结果
     */
	public int deleteAdminGroupById(Long id);
	
	/**
     * 批量删除管理员机构关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAdminGroupByIds(String[] ids);
	
}