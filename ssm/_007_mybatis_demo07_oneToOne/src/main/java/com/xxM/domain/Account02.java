package com.xxM.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Program: IntelliJ IDEA ssm
 * @Description: 多对一
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-09-28 19:51:08 周六
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
@Data
public class Account02 implements Serializable {
    private Integer aid  ;
    private Double money;
    private Integer uid  ;
    private User user;
}
