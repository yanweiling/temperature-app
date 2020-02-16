package com.windsound.project.entity.vo;

import com.windsound.project.common.DateUtils;
import com.windsound.project.common.annotation.Excel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.charts.ScatterChartSeries;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Getter
@Setter
public class UserVo {
    //wxuser信息
    @Excel(name = "序号")
    private Integer orderKey;
    private String ninkName;
    @Excel(name = "用户名称")
    private String userName;
    @Excel(name = "联系电话")
    private String tel;
    @Excel(name = "身份证")
    private String idCard;
    private String openId;
    //userInfo信息
    @Excel(name = "健康信息监测时间")
    private String uploadTime;
    /** 是否到岗 */
    private Integer isDuty;
    @Excel(name = "当前所在地址")
    private String currAddress;
    @Excel(name = "是否到岗")
    private String isDutyDesc;
    /** 体温 */
    @Excel(name = "体温")
    private BigDecimal temperature;
    /** 当前流动地址 */
    private Integer isSelfFeverCough;
    @Excel(name = "本人是否发热咳嗽")
    private String isSelfFeverCoughDesc;
    /** 家人是否发热咳嗽 */
    private Integer isOtherFeverCough;
    @Excel(name = "家人是否发热咳嗽")
    private String isOtherFeverCoughDesc;
    /** 本人是否去过武汉 */
    private Integer isSelfPassWuhan;
    @Excel(name = "本人是否去过武汉")
    private String isSelfPassWuhanDesc;
    /** 家人是否去过武汉 */
    private Integer isOtherPassWuhan;
    @Excel(name = "家人是否去过武汉")
    private String isOtherPassWuhanDesc;
    private Integer isSelfTouchHubei;
    @Excel(name = "本人是否接触过武汉")
    private String isSelfTouchHubeiDesc;
    /** 家人是否接触过湖北 */
    private Integer isOtherTouchHubei;
    @Excel(name = "家人是否接触过湖北")
    private String isOtherTouchHubeiDesc;
    /** 备注 */
    @Excel(name = "备注")
    private String remark;
    /** 创建时间 */
    private Date createTime;
    @Excel(name = "提交时间")
    private String createTimeDesc;
    public void setIsDuty(Integer isDuty) {
        this.isDuty = isDuty;
        switch (this.isDuty){
            case 1:
                setIsDutyDesc("否");
                break;
            case 2:
                setIsDutyDesc("是");
                break;
        }
    }

    public void setIsSelfFeverCough(Integer isSelfFeverCough) {
        this.isSelfFeverCough = isSelfFeverCough;
        switch (this.isSelfFeverCough){
            case 1:
                setIsSelfFeverCoughDesc("否");
                break;
            case 2:
                setIsSelfFeverCoughDesc("是");
                break;
        }
    }


    public void setIsOtherFeverCough(Integer isOtherFeverCough) {
        this.isOtherFeverCough = isOtherFeverCough;
        switch (this.isOtherFeverCough){
            case 1:
                setIsOtherFeverCoughDesc("否");
                break;
            case 2:
                setIsOtherFeverCoughDesc("是");
                break;
        }
    }

    public void setIsSelfPassWuhan(Integer isSelfPassWuhan) {
        this.isSelfPassWuhan = isSelfPassWuhan;
        switch (this.isSelfPassWuhan){
            case 1:
                setIsSelfPassWuhanDesc("否");
                break;
            case 2:
                setIsSelfPassWuhanDesc("是");
                break;
        }
    }

    public void setIsOtherPassWuhan(Integer isOtherPassWuhan) {
        this.isOtherPassWuhan = isOtherPassWuhan;
        switch (this.isOtherPassWuhan){
            case 1:
                setIsOtherPassWuhanDesc("否");
                break;
            case 2:
                setIsOtherPassWuhanDesc("是");
                break;
        }
    }

    public void setIsSelfTouchHubei(Integer isSelfTouchHubei) {
        this.isSelfTouchHubei = isSelfTouchHubei;
        switch (this.isSelfTouchHubei){
            case 1:
                setIsSelfTouchHubeiDesc("否");
                break;
            case 2:
                setIsSelfTouchHubeiDesc("是");
                break;
        }
    }

    public  void setIsOtherTouchHubei(Integer isOtherTouchHubei) {
        this.isOtherTouchHubei = isOtherTouchHubei;
        switch (this.isOtherTouchHubei){
            case 1:
                setIsOtherTouchHubeiDesc("否");
                break;
            case 2:
                setIsOtherTouchHubeiDesc("是");
                break;
        }
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format=new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        setCreateTimeDesc(format.format(createTime));
    }

    public static void main(String[] args) {
        UserVo vo=new UserVo();
        vo.setIsOtherFeverCough(2);
        System.out.println(vo.getIsOtherFeverCoughDesc());
    }
}
