package com.xxM.dao;

import com.xxM.domain.Account;
import com.xxM.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
public interface AccountDao {
    @Select("select * from t_account where uid=#{uid}")
    List<Account> findAccountList(Integer uid);
    @Select("select * from t_user")
    @Results(value = {
            @Result(column = "uid",property = "uid",id = true),
            @Result(column = "username",property = "username"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "address",property = "address"),
            @Result(column = "uid",property = "accounts",
                    many = @Many(select = "com.xxM.dao.AccountDao.findAccountList",fetchType = FetchType.LAZY)),
    })
    List<User> findUserList();
}
