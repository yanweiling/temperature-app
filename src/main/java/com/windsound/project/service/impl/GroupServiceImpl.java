package com.windsound.project.service.impl;

import java.util.List;

import com.windsound.project.entity.Group;
import com.windsound.project.mapper.GroupMapper;
import com.windsound.project.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 机构 服务层实现
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Service
public class GroupServiceImpl implements IGroupService
{
	@Autowired
	private GroupMapper groupMapper;

	/**
     * 查询机构信息
     * 
     * @param id 机构ID
     * @return 机构信息
     */
    @Override
	public Group selectGroupById(Long id)
	{
	    return groupMapper.selectGroupById(id);
	}
	
	/**
     * 查询机构列表
     * 
     * @param group 机构信息
     * @return 机构集合
     */
	@Override
	public List<Group> selectGroupList(Group group)
	{
	    return groupMapper.selectGroupList(group);
	}
	
    /**
     * 新增机构
     * 
     * @param group 机构信息
     * @return 结果
     */
	@Override
	public int insertGroup(Group group)
	{
	    return groupMapper.insertGroup(group);
	}
	
	/**
     * 修改机构
     * 
     * @param group 机构信息
     * @return 结果
     */
	@Override
	public int updateGroup(Group group)
	{
	    return groupMapper.updateGroup(group);
	}

}
