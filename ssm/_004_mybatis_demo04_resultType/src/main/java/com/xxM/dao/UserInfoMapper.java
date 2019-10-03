package com.xxM.dao;

import com.xxM.domain.User;
import com.xxM.domain.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    //新增用户
    int countAll();
    List<UserInfo> queryAll();
    List<UserInfo> queryAll2();
    List<UserInfo> queryAll3();
}
