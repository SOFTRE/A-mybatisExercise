package com.xxM.dao;

import com.xxM.domain.Account;
import com.xxM.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountMapper {
    @Select("select * from t_user")
    List<User> findUserList();
    @Select("select * from t_user where uid=#{uid}")
    User fingById(Integer uid);
    @Insert("insert into t_user (username,birthday,sex,address)values(#{username},#{birthday},#{sex},#{address})")
    @SelectKey(
            statement = "select last_insert_id()",
            keyProperty = "uid",
            resultType = Integer.class,
            before = false
    )
    Integer addUser(User user);

    @Update("update t_user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where uid=#{uid}")
    Integer updateUser(User user);

    @Delete("delete from t_user where uid=#{uid}")
    Integer delete(Integer uid);

    @Select("select *  from t_account where aid=#{aid}")
    @Results({
            @Result(column = "aid", property = "aid", id = true),
            @Result(column = "money", property = "money"),
            @Result(column = "uid", property = "uid"),
            @Result(
                    property = "user",
                    column = "uid",
                    javaType = User.class,
                    one = @One(
                            select = "com.xxM.dao.UserMapper.findUser",
                            fetchType = FetchType.LAZY
                    )
            )
    })
    Account findAccount(Integer aid);
}
