package com.xxM.domain;

import lombok.Data;

/**
 * @Program: IntelliJ IDEA ssm
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-09-29 14:07:52 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
@Data
public class Account {
    private Integer aid;
    private Double money;
    private Integer uid;
    private User user;
}
