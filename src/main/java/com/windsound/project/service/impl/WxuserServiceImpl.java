package com.windsound.project.service.impl;

import java.util.List;

import com.windsound.project.entity.Wxuser;
import com.windsound.project.mapper.WxuserMapper;
import com.windsound.project.service.IWxuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 微信用户 服务层实现
 * 
 * @author yanwlb
 * @date 2020-02-13
 */
@Service
public class WxuserServiceImpl implements IWxuserService
{
	@Autowired
	private WxuserMapper wxuserMapper;

	/**
     * 查询微信用户信息
     * 
     * @param id 微信用户ID
     * @return 微信用户信息
     */
    @Override
	public Wxuser selectWxuserById(Long id)
	{
	    return wxuserMapper.selectWxuserById(id);
	}
	
	/**
     * 查询微信用户列表
     * 
     * @param wxuser 微信用户信息
     * @return 微信用户集合
     */
	@Override
	public List<Wxuser> selectWxuserList(Wxuser wxuser)
	{
	    return wxuserMapper.selectWxuserList(wxuser);
	}
	
    /**
     * 新增微信用户
     * 
     * @param wxuser 微信用户信息
     * @return 结果
     */
	@Override
	public int insertWxuser(Wxuser wxuser)
	{
	    return wxuserMapper.insertWxuser(wxuser);
	}
	
	/**
     * 修改微信用户
     * 
     * @param wxuser 微信用户信息
     * @return 结果
     */
	@Override
	public int updateWxuser(Wxuser wxuser)
	{
	    return wxuserMapper.updateWxuser(wxuser);
	}

}
