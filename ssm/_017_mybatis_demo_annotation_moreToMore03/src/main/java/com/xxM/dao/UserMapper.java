package com.xxM.dao;

import com.xxM.domain.User;
import org.apache.ibatis.annotations.Select;

/**
 * @Program: IntelliJ IDEA ssm
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-03 10:27:35 周四
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public interface UserMapper {
    @Select("select * from t_user where uid=#{uid}")
    User findUser(Integer uid);
}
