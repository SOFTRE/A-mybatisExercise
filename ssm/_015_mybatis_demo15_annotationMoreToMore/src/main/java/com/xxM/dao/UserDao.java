package com.xxM.dao;

import com.xxM.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from t_user where uid=#{uid}")
    User findById(Integer uid);
}
