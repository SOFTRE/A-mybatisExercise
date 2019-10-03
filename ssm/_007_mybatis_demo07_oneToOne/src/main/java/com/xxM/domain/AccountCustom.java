package com.xxM.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @Program: IntelliJ IDEA ssm
 * @Description: 包含账户信息，同时需要包含用户信息
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-09-28 19:30:57 周六
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
@Data
@ToString(callSuper = true)//调用父类属性和方法
public class AccountCustom extends Account {
//    private Integer aid  ;
//    private Double money;
//    private Integer uid  ;
//以上是查询结果(一对一)显示，此类中有的就显示，没有就不显示
    private String username;
    private String address;
}
