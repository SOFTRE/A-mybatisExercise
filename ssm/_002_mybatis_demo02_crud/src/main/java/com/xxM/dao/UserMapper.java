package com.xxM.dao;

import com.xxM.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll(String order);
    //根据id查询一个用户
    User findById(Integer id);
    //新增用户
    int addUser(User user);
    int deleteById(Integer id);
    int updateById(User user);
    List<User> findByAddress(String address);
    List<User> findByAddress2(String address);
}
