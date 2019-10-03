package com.xxM.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Program: IntelliJ IDEA ssm
 * @Description: this is a info
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-09-27 16:36:00 周五
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE 2019.2
 */
@Data
public class UserInfo {
    private Integer userId;     //  int(11)
    private String userName;    //  varchar(32)
    private Date userBirthday;  //  datetime
    private String userSex;     //  char(1)
    private String userAddress; //  varchar(256)

}
