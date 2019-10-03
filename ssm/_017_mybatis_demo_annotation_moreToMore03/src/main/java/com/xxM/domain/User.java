package com.xxM.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Program: IntelliJ IDEA ssm
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-03 10:27:41 周四
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
@Data
public class User {
    private Integer uid;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    private Account  account;
}
