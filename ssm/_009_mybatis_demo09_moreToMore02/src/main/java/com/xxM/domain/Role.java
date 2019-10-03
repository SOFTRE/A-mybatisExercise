package com.xxM.domain;

import lombok.Data;

import java.util.List;

/**
 * @Program: IntelliJ IDEA ssm
 * @Description: 包含用户信息
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-09-28 22:08:46 周六
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
@Data
public class Role {
    private Integer rid  ;
    private String rName;
    private String rDesc;
    private List<User> users;
}
