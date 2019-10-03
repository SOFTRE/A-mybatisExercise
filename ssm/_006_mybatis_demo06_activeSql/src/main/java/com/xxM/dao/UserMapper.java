package com.xxM.dao;

import com.xxM.domain.User;
import com.xxM.domain.QueryVo;

import java.util.List;

public interface UserMapper {
    List<User> findByQueryVo(QueryVo queryVo);
}
