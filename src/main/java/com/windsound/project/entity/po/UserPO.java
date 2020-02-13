package com.windsound.project.entity.po;

import com.windsound.project.entity.Userinfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserPO {
    String openId;
    String userName;
    String idCard;
    String tel;
    Userinfo userinfo;
}
