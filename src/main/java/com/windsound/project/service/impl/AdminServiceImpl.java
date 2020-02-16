package com.windsound.project.service.impl;

import java.util.Date;
import java.util.List;

import com.windsound.project.entity.Admin;
import com.windsound.project.entity.AdminGroup;
import com.windsound.project.entity.Group;
import com.windsound.project.entity.po.AdminGroupPO;
import com.windsound.project.mapper.AdminGroupMapper;
import com.windsound.project.mapper.AdminMapper;
import com.windsound.project.mapper.GroupMapper;
import com.windsound.project.service.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * 管理员 服务层实现
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Service
@Slf4j
public class AdminServiceImpl implements IAdminService
{
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private GroupMapper groupMapper;
	@Autowired
	private AdminGroupMapper adminGroupMapper;
	/**
	 * 查询管理员信息
	 */
	@Override
	public Admin selectAdmin(Admin admin)
	{
		return adminMapper.selectAdmin(admin);
	}


	/**
     * 查询管理员信息
     * 
     * @param id 管理员ID
     * @return 管理员信息
     */
    @Override
	public Admin selectAdminById(Long id)
	{
	    return adminMapper.selectAdminById(id);
	}
	
	/**
     * 查询管理员列表
     * 
     * @param admin 管理员信息
     * @return 管理员集合
     */
	@Override
	public List<Admin> selectAdminList(Admin admin)
	{
	    return adminMapper.selectAdminList(admin);
	}
	
    /**
     * 新增管理员
     * 
     * @param admin 管理员信息
     * @return 结果
     */
	@Override
	public int insertAdmin(Admin admin)
	{
	    return adminMapper.insertAdmin(admin);
	}
	
	/**
     * 修改管理员
     * 
     * @param admin 管理员信息
     * @return 结果
     */
	@Override
	public int updateAdmin(Admin admin)
	{
	    return adminMapper.updateAdmin(admin);
	}

	@Override
	@Transactional
	public void registerAdminAndGroup(AdminGroupPO adminGroupPO) {
		Admin admin=new Admin();
		admin.setLoginName(adminGroupPO.getLoginName());
		admin.setLoginPwd(adminGroupPO.getLoginPwd());
		admin.setCreateDate(new Date());
		adminMapper.insertAdmin(admin);
		//注册组织机构
		String groupName=adminGroupPO.getGroupName();
		Group group=new Group();
		group.setGroupName(groupName);
		List<Group> groups=groupMapper.selectGroupList(group);
		if(!CollectionUtils.isEmpty(groups)){
			log.warn("该企业，机构已经存在");
			group.setId(groups.get(0).getId());
		}else{
			group.setCreateTime(new Date());
			group.setAuditStatus(1);//正常状态默认是1
			groupMapper.insertGroup(group);
			log.info("新增企业，机构成功");
		}
		//管理员和机构关联关系
		AdminGroup adminGroup=new AdminGroup();
		adminGroup.setGroupId(group.getId());
		adminGroup.setAdminId(admin.getId());
		adminGroupMapper.insertAdminGroup(adminGroup);
		log.info("管理员机构关联成功");

	}
}
