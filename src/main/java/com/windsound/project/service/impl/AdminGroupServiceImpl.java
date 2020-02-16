package com.windsound.project.service.impl;

import java.util.List;

import com.windsound.project.entity.AdminGroup;
import com.windsound.project.mapper.AdminGroupMapper;
import com.windsound.project.service.IAdminGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员机构关联 服务层实现
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Service
public class AdminGroupServiceImpl implements IAdminGroupService
{
	@Autowired
	private AdminGroupMapper adminGroupMapper;

	/**
     * 查询管理员机构关联信息
     * 
     * @param id 管理员机构关联ID
     * @return 管理员机构关联信息
     */
    @Override
	public AdminGroup selectAdminGroupById(Long id)
	{
	    return adminGroupMapper.selectAdminGroupById(id);
	}
	
	/**
     * 查询管理员机构关联列表
     * 
     * @param adminGroup 管理员机构关联信息
     * @return 管理员机构关联集合
     */
	@Override
	public List<AdminGroup> selectAdminGroupList(AdminGroup adminGroup)
	{
	    return adminGroupMapper.selectAdminGroupList(adminGroup);
	}
	
    /**
     * 新增管理员机构关联
     * 
     * @param adminGroup 管理员机构关联信息
     * @return 结果
     */
	@Override
	public int insertAdminGroup(AdminGroup adminGroup)
	{
	    return adminGroupMapper.insertAdminGroup(adminGroup);
	}
	
	/**
     * 修改管理员机构关联
     * 
     * @param adminGroup 管理员机构关联信息
     * @return 结果
     */
	@Override
	public int updateAdminGroup(AdminGroup adminGroup)
	{
	    return adminGroupMapper.updateAdminGroup(adminGroup);
	}

}
