package com.windsound.project.service;

import com.windsound.project.entity.Admin;
import com.windsound.project.entity.AdminGroup;
import com.windsound.project.entity.po.AdminGroupPO;

import java.util.List;

/**
 * 管理员 服务层
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
public interface IAdminService 
{
	public Admin selectAdmin(Admin admin);
	/**
     * 查询管理员信息
     * 
     * @param id 管理员ID
     * @return 管理员信息
     */
	public Admin selectAdminById(Long id);
	
	/**
     * 查询管理员列表
     * 
     * @param admin 管理员信息
     * @return 管理员集合
     */
	public List<Admin> selectAdminList(Admin admin);
	
	/**
     * 新增管理员
     * 
     * @param admin 管理员信息
     * @return 结果
     */
	public int insertAdmin(Admin admin);
	
	/**
     * 修改管理员
     * 
     * @param admin 管理员信息
     * @return 结果
     */
	public int updateAdmin(Admin admin);

	public void registerAdminAndGroup(AdminGroupPO adminGroupPO);

}
