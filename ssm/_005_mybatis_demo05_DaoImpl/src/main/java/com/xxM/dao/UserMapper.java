package com.xxM.dao;

import com.xxM.domain.User;

import java.util.List;

public interface UserMapper {
    public User findById(Integer id);
    public List<User> findByUserName(String userName);
    public int addUser(User user);
}
