package com.windsound.project.entity.po;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AdminGroupPO {
    /** 登录名称 */
    private String loginName;
    /** 密码 */
    private String loginPwd;
    /** 机构名称 */
    private String groupName;
    /** 地址 */
    private String address;
}
