package com.xxM.dao;

import com.xxM.domain.Account;
import com.xxM.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
public interface AccountDao {
    @Select("select * from t_account")
    @Results(value = {
         @Result(column = "aid",property = "aid",id = true),
            @Result(column = "money",property = "money"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "uid",property = "user",
                    one = @One(select = "com.xxM.dao.UserDao.findById",fetchType = FetchType.LAZY)),
    })
    List<Account> findAccountList();
}
