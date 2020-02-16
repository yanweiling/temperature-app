package com.windsound.project.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 管理员表 admin
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Data
@Getter
@Setter
public class Admin
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 登录名称 */
	private String loginName;
	/** 密码 */
	private String loginPwd;
	/** 创建时间 */
	private Date createDate;
}
