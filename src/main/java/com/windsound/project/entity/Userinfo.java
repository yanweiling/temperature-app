package com.windsound.project.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户表 userinfo
 * 
 * @author yanwlb
 * @date 2020-02-13
 */
public class Userinfo
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 外键 */
	private Long wxid;
	/** 当前年月日 格式yyyyMMdd */
	private String uploadTime;
	/** 是否到岗 */
	private Integer isDuty;
	/** 体温 */
	private BigDecimal temperature;
	/** 当前流动地址 */
	private String currAddress;
	/** 住址 */
	private String address;
	/** 是否发热咳嗽 */
	private Integer isSelfFeverCough;
	/** 家人是否发热咳嗽 */
	private Integer isOtherFeverCough;
	/** 本人是否去过武汉 */
	private Integer isSelfPassWuhan;
	/** 家人是否去过武汉 */
	private Integer isOtherPassWuhan;
	/** 本人是否接触过武汉 */
	private Integer isSelfTouchHubei;
	/** 家人是否接触过湖北 */
	private Integer isOtherTouchHubei;
	/** 本人是否接触过温州 */
	private Integer isSelfTouchWenzhou;
	/** 家人是否接触过温州 */
	private Integer isOtherTouchWenzhou;
	/** 备注 */
	private String remark;
	/** 创建时间 */
	private Date createTime;

	public static boolean isAllEmpty(Userinfo userinfo){
		if(userinfo.getIsDuty()==null &&
		userinfo.getTemperature()==null &&
				StringUtils.isEmpty(userinfo.getAddress()) &&
		userinfo.getIsSelfFeverCough()==null &&
		userinfo.getIsSelfPassWuhan()==null &&
		userinfo.getIsSelfTouchHubei()==null &&
		userinfo.getIsSelfTouchWenzhou()==null &&
		userinfo.getIsOtherFeverCough()==null &&
		userinfo.getIsOtherPassWuhan()==null &&
		userinfo.getIsOtherTouchHubei()==null &&
		userinfo.getIsOtherTouchWenzhou()==null){
			return true;
		}
		return false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getWxid() {
		return wxid;
	}

	public void setWxid(Long wxid) {
		this.wxid = wxid;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Integer getIsDuty() {
		return isDuty;
	}

	public void setIsDuty(Integer isDuty) {
		this.isDuty = isDuty;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public String getCurrAddress() {
		return currAddress;
	}

	public void setCurrAddress(String currAddress) {
		this.currAddress = currAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getIsSelfFeverCough() {
		return isSelfFeverCough;
	}

	public void setIsSelfFeverCough(Integer isSelfFeverCough) {
		this.isSelfFeverCough = isSelfFeverCough;
	}

	public Integer getIsOtherFeverCough() {
		return isOtherFeverCough;
	}

	public void setIsOtherFeverCough(Integer isOtherFeverCough) {
		this.isOtherFeverCough = isOtherFeverCough;
	}

	public Integer getIsSelfPassWuhan() {
		return isSelfPassWuhan;
	}

	public void setIsSelfPassWuhan(Integer isSelfPassWuhan) {
		this.isSelfPassWuhan = isSelfPassWuhan;
	}

	public Integer getIsOtherPassWuhan() {
		return isOtherPassWuhan;
	}

	public void setIsOtherPassWuhan(Integer isOtherPassWuhan) {
		this.isOtherPassWuhan = isOtherPassWuhan;
	}

	public Integer getIsSelfTouchHubei() {
		return isSelfTouchHubei;
	}

	public void setIsSelfTouchHubei(Integer isSelfTouchHubei) {
		this.isSelfTouchHubei = isSelfTouchHubei;
	}

	public Integer getIsOtherTouchHubei() {
		return isOtherTouchHubei;
	}

	public void setIsOtherTouchHubei(Integer isOtherTouchHubei) {
		this.isOtherTouchHubei = isOtherTouchHubei;
	}

	public Integer getIsSelfTouchWenzhou() {
		return isSelfTouchWenzhou;
	}

	public void setIsSelfTouchWenzhou(Integer isSelfTouchWenzhou) {
		this.isSelfTouchWenzhou = isSelfTouchWenzhou;
	}

	public Integer getIsOtherTouchWenzhou() {
		return isOtherTouchWenzhou;
	}

	public void setIsOtherTouchWenzhou(Integer isOtherTouchWenzhou) {
		this.isOtherTouchWenzhou = isOtherTouchWenzhou;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
