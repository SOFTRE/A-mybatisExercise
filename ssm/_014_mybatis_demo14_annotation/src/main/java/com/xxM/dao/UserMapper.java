package com.xxM.dao;

import com.xxM.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface UserMapper {
    @Select("select * from t_user ${value}")
    List<User> findAll(String orderby);
    @Select("select * from t_user where uid=#{uid}")
    User findById(Integer uid);
    @SelectKey(keyProperty = "uid",resultType = int.class,before = false,statement="SELECT LAST_INSERT_ID()")
    @Insert("INSERT INTO t_user(username,sex,birthday,address)VALUES(#{username},#{sex},#{birthday},#{address})")
    void add(User user);


    @Update("UPDATE t_user SET  username = #{username} ,sex = #{sex}, birthday = #{birthday},address = #{address} WHERE uid = #{uid}")
    void update(User user);


    @Delete("DELETE  FROM t_user WHERE uid = #{uid}")
    void delete(int uid);


    @Select("SELECT * FROM t_user WHERE username like concat('%',#{firstName},'%')")
    List<User> findByFirstName(String firstName);
}
