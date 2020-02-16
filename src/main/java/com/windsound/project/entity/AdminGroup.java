package com.windsound.project.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 管理员机构关联表 admin_group
 * 
 * @author yanwlb
 * @date 2020-02-15
 */
@Data
@Getter
@Setter
public class AdminGroup
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/**  */
	private Long adminId;
	/**  */
	private Long groupId;

}
