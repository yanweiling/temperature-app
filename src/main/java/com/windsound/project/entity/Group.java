package com.windsound.project.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 机构表 group
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Data
@Getter
@Setter
public class Group
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 机构唯一标识 */
	private String groupPid;
	/** 机构名称 */
	private String groupName;
	/** 地址 */
	private String address;
	/** 状态 */
	private Integer auditStatus;
	/** 创建时间 */
	private Date createTime;


}
