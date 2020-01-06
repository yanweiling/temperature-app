package com.windsound.project.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 微信用户表 wx_user
 * 
 * @author admin
 * @date 2019-12-30
 */
@Data
@Getter
@Setter
public class User
{
	private static final long serialVersionUID = 1L;
	
	/** UUID */
	private String id;
	/**  */
	private String openId;
	/** 昵称 */
	private String nickName;
	/** 微信头像 */
	private String headPhoto;
	/** 性别 */
	private String gender;
	/** 口音类型 */
	private String accentType;
	/** 是否是普通话 0方言 1普通话 */
	private Integer isStandard;
	/** 年龄段 */
	private String ageLevel;
	/** 手机号 */
	private String tel;
	/**  */
	private Date createTime;
	/** 用户类型 格式：口音-年龄阶段-性别 */
	private String speakerType;
}
