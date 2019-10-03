package com.xxM;

import com.xxM.dao.Impl.UserMapperImpl;
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
    @Before
    public void before() throws IOException {
        //1. 读取SqlMapConfig.xml获得输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
            is.close();
        //4.通过namespace.id调用
        mapperProxy = new UserMapperImpl(sqlSessionFactory);
    }

    @Test
    public void method() throws IOException {
        System.out.println(mapperProxy.findById(1));
    }
    @Test
    public void method2() throws IOException {
        List<User> list=mapperProxy.findByUserName("上");
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void method3() throws IOException {
        User user=new User();
        user.setUsername("zs");
        user.setBirthday(new Date());
        user.setAddress("beijing");
        user.setSex("男");
        int i = mapperProxy.addUser(user);
        System.out.println(i);
    }

}
