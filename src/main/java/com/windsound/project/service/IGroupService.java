package com.windsound.project.service;

import com.windsound.project.entity.Group;

import java.util.List;

/**
 * 机构 服务层
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
public interface IGroupService 
{
	/**
     * 查询机构信息
     * 
     * @param id 机构ID
     * @return 机构信息
     */
	public Group selectGroupById(Long id);
	
	/**
     * 查询机构列表
     * 
     * @param group 机构信息
     * @return 机构集合
     */
	public List<Group> selectGroupList(Group group);
	
	/**
     * 新增机构
     * 
     * @param group 机构信息
     * @return 结果
     */
	public int insertGroup(Group group);
	
	/**
     * 修改机构
     * 
     * @param group 机构信息
     * @return 结果
     */
	public int updateGroup(Group group);

}
