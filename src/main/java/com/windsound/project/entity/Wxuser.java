package com.windsound.project.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 微信用户表 wxuser
 * 
 * @author yanwlb
 * @date 2020-02-13
 */
public class Wxuser
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 微信昵称 */
	private String ninkName;
	/** 微信编码 */
	private String openId;
	/** 个人头像 */
	private String avatarUrl;
	/** 姓名 */
	private String name;
	/** 身份证号 */
	private String idCard;
	/** 电话 */
	private String tel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNinkName() {
		return ninkName;
	}

	public void setNinkName(String ninkName) {
		this.ninkName = ninkName;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
