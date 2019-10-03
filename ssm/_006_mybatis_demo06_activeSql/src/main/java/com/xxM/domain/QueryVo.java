package com.xxM.domain;

import com.xxM.domain.User;
import lombok.Data;

import java.util.List;

/**
 * @Program: IntelliJ IDEA ssm
 * @Description: this active append sql class
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-09-28 16:35:07 周六
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
@Data
public class QueryVo {
    private User user;
    private List<Integer> ads;
}
