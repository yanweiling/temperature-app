package com.windsound.project.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.windsound.project.common.AjaxResult;
import com.windsound.project.common.DateUtils;
import com.windsound.project.entity.Userinfo;
import com.windsound.project.entity.Wxuser;
import com.windsound.project.entity.po.UserPO;
import com.windsound.project.entity.vo.UserVo;
import com.windsound.project.mapper.UserinfoMapper;
import com.windsound.project.service.IUserinfoService;
import com.windsound.project.service.IWxuserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


/**
 * 用户 服务层实现
 * 
 * @author yanwlb
 * @date 2020-02-13
 */
@Service
public class UserinfoServiceImpl implements IUserinfoService
{
	private static Logger logger= LoggerFactory.getLogger(UserinfoServiceImpl.class);
	@Autowired
	private UserinfoMapper userinfoMapper;

	@Autowired
	private IWxuserService wxuserService;

	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
	public Userinfo selectUserinfoById(Long id)
	{
	    return userinfoMapper.selectUserinfoById(id);
	}
	
	/**
     * 查询用户列表
     * 
     * @param userinfo 用户信息
     * @return 用户集合
     */
	@Override
	public List<Userinfo> selectUserinfoList(Userinfo userinfo)
	{
	    return userinfoMapper.selectUserinfoList(userinfo);
	}

	@Override
	public List<UserVo> selectUserVoList(UserVo userVo)
	{
		return userinfoMapper.selectUserVoList(userVo);
	}
	@Override
	public List<UserVo> selectUserVoList(Map<String,Object> param){
		return userinfoMapper.selectUserVoListForPage(param);
	}
	@Override
	public Integer selectCount(Map<String,Object> param){
		return userinfoMapper.selectCount(param);
	}
    /**
     * 新增用户
     * 
     * @param userinfo 用户信息
     * @return 结果
     */
	@Override
	public int insertUserinfo(Userinfo userinfo)
	{
	    return userinfoMapper.insertUserinfo(userinfo);
	}
	
	/**
     * 修改用户
     * 
     * @param userinfo 用户信息
     * @return 结果
     */
	@Override
	public int updateUserinfo(Userinfo userinfo)
	{
	    return userinfoMapper.updateUserinfo(userinfo);
	}


	@Transactional
	public AjaxResult insertUserPo(UserPO userPO){
		try{
			String openId=userPO.getOpenId();
			Wxuser mockUser =new Wxuser();
			mockUser.setOpenId(openId);
			List<Wxuser> wxusers=wxuserService.selectWxuserList(mockUser);
			if(CollectionUtils.isEmpty(wxusers)){
				return AjaxResult.error("微信用户里没有该用户信息，数据异常，请联系管理员");
			}
			Wxuser currentUser=wxusers.get(0);
			Long wxUserId=currentUser.getId();
			String dateFormate= DateUtils.getDate();
			Userinfo userinfo=new Userinfo();
			userinfo.setWxid(wxUserId);
			userinfo.setUploadTime(dateFormate);
			List<Userinfo> userinfos=selectUserinfoList(userinfo);
			//设置参数
			userinfo.setIsSelfPassWuhan(userPO.getUserinfo().getIsSelfPassWuhan());
			userinfo.setIsSelfFeverCough(userPO.getUserinfo().getIsSelfFeverCough());
			userinfo.setIsSelfTouchHubei(userPO.getUserinfo().getIsSelfTouchHubei());
			userinfo.setIsSelfTouchWenzhou(userPO.getUserinfo().getIsSelfTouchWenzhou());
			userinfo.setIsOtherFeverCough(userPO.getUserinfo().getIsOtherFeverCough());
			userinfo.setIsOtherPassWuhan(userPO.getUserinfo().getIsOtherPassWuhan());
			userinfo.setIsOtherTouchHubei(userPO.getUserinfo().getIsOtherTouchHubei());
			userinfo.setIsOtherTouchWenzhou(userPO.getUserinfo().getIsOtherTouchWenzhou());
			userinfo.setCurrAddress(userPO.getUserinfo().getCurrAddress());
			userinfo.setIsDuty(userPO.getUserinfo().getIsDuty());
			userinfo.setTemperature(userPO.getUserinfo().getTemperature());
			userinfo.setRemark(userPO.getUserinfo().getRemark());
			userinfo.setCreateTime(new Date());
			//如果用户存在则更新
			if(CollectionUtils.isEmpty(userinfos)){
				//插入
				insertUserinfo(userinfo);
			}else{
				//更新
				Long userinfoId=userinfos.get(0).getId();
				userinfo.setId(userinfoId);
				updateUserinfo(userinfo);
			}
			//更新用户基本信息
			Wxuser wxuser =new Wxuser();
			wxuser.setName(userPO.getUserName().trim());
			wxuser.setIdCard(userPO.getIdCard().trim());
			wxuser.setTel(userPO.getTel().trim());
			wxuser.setOpenId(userPO.getOpenId());
			wxuserService.updateWxuser(wxuser);
			return AjaxResult.success("成功");
		}catch (Exception e){
			logger.error("录入用户健康信息发生异常",e);
			return AjaxResult.error("录入用户健康信息发生异常");
		}
	}
	
}
