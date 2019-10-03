package com.xxM.dao.Impl;

import com.xxM.dao.UserMapper;
import com.xxM.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Program: IntelliJ IDEA ssm
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-09-27 22:48:17 周五
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class UserMapperImpl implements UserMapper {
    SqlSessionFactory sqlSessionFactory;

    public UserMapperImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findById(Integer id) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=sqlSession.selectOne("findById",id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findByUserName(String userName) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<User> users=sqlSession.selectList("UserMapper.findByUserName",userName);
        sqlSession.close();
        return users;
    }

    @Override
    public int addUser(User user) {
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        int count=sqlSession.insert("UserMapper.addUser",user);
//        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
