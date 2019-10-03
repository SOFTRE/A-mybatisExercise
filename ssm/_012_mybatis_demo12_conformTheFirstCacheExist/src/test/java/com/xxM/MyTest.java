package com.xxM;

import com.xxM.dao.UserMapper;
import com.xxM.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Program: IntelliJ IDEA ssm
 * @Description: this is a testClass
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-09-26 17:13:28 周四
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */

public class MyTest {
    SqlSession sqlSession;
    UserMapper mapperProxy;
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws IOException {
        //1. 读取SqlMapConfig.xml获得输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(is);
        is.close();
        //3. 获得SqlSession

    }
    @Test
    public void method1() throws IOException {
        sqlSession = sqlSessionFactory.openSession();
        //4.通过namespace.id调用
        mapperProxy = sqlSession.getMapper(UserMapper.class);
        User user1=mapperProxy.findById(1);
        User user2=mapperProxy.findById(1);
        //5.打印输出
        System.out.println(user1);
        System.out.println(user2);
        sqlSession.close();
        sqlSession = sqlSessionFactory.openSession();
        //4.通过namespace.id调用
        mapperProxy = sqlSession.getMapper(UserMapper.class);
        User user3=mapperProxy.findById(1);
        System.out.println(user3);
    }
    @Test
    public void method(){
        User user=mapperProxy.findById(1);
        //5.打印输出
        System.out.println(user);
    }
}
