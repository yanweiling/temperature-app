package com.windsound.project.mapper;

import com.windsound.project.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员 数据层
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Repository
public interface AdminMapper 
{
	/**
	 * 查询管理员信息
	 *
	 * @param id 管理员ID
	 * @return 管理员信息
	 */
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
	
	/**
     * 删除管理员
     * 
     * @param id 管理员ID
     * @return 结果
     */
	public int deleteAdminById(Long id);
	
	/**
     * 批量删除管理员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAdminByIds(String[] ids);
	
}