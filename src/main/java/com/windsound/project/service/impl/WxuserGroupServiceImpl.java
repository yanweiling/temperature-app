package com.windsound.project.service.impl;

import java.util.List;

import com.windsound.project.entity.WxuserGroup;
import com.windsound.project.mapper.WxuserGroupMapper;
import com.windsound.project.service.IWxuserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 微信用户机构关联 服务层实现
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Service
public class WxuserGroupServiceImpl implements IWxuserGroupService
{
	@Autowired
	private WxuserGroupMapper wxuserGroupMapper;

	/**
     * 查询微信用户机构关联信息
     * 
     * @param id 微信用户机构关联ID
     * @return 微信用户机构关联信息
     */
    @Override
	public WxuserGroup selectWxuserGroupById(Long id)
	{
	    return wxuserGroupMapper.selectWxuserGroupById(id);
	}
	
	/**
     * 查询微信用户机构关联列表
     * 
     * @param wxuserGroup 微信用户机构关联信息
     * @return 微信用户机构关联集合
     */
	@Override
	public List<WxuserGroup> selectWxuserGroupList(WxuserGroup wxuserGroup)
	{
	    return wxuserGroupMapper.selectWxuserGroupList(wxuserGroup);
	}
	
    /**
     * 新增微信用户机构关联
     * 
     * @param wxuserGroup 微信用户机构关联信息
     * @return 结果
     */
	@Override
	public int insertWxuserGroup(WxuserGroup wxuserGroup)
	{
	    return wxuserGroupMapper.insertWxuserGroup(wxuserGroup);
	}
	
	/**
     * 修改微信用户机构关联
     * 
     * @param wxuserGroup 微信用户机构关联信息
     * @return 结果
     */
	@Override
	public int updateWxuserGroup(WxuserGroup wxuserGroup)
	{
	    return wxuserGroupMapper.updateWxuserGroup(wxuserGroup);
	}

}
