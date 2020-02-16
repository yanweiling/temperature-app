package com.windsound.project.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 微信用户机构关联表 wxuser_group
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Data
@Getter
@Setter
public class WxuserGroup
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 微信用户id */
	private Long wxuserId;
	/** 机构id */
	private Long groupId;

}
