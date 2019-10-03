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
    @Before
    public void before() throws IOException {
        //1. 读取SqlMapConfig.xml获得输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        is.close();
        //3. 获得SqlSession
        sqlSession = sqlSessionFactory.openSession();
        //4.通过namespace.id调用
        mapperProxy = sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void method() throws IOException {
        List<User> users = mapperProxy.findAll("order by id desc");
        //5.打印输出
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void method1() throws IOException {
        User user=mapperProxy.findById(1);
        //5.打印输出
        System.out.println(user);
    }
    @Test
    public void method2() throws IOException {
        User user=mapperProxy.findById(1);
        user.setUsername("俩小儿辩日");
        user.setId(null);
       int len=mapperProxy.addUser(user);
        //5.打印输出
        System.out.println(user);
        System.out.println(len);
    }
    @Test
    public void method3() throws IOException {
        for (int i = 6; i <8 ; i++) {
            int len=mapperProxy.deleteById(i);
            System.out.println(len);
        }
    }
    @Test
    public void method4() throws IOException {
        User user=mapperProxy.findById(1);
        user.setUsername("上善若水");
        user.setBirthday(new Date());
        user.setAddress("beijing");
        user.setSex("女");
        int len=mapperProxy.updateById(user);
        System.out.println(len);
    }
    @Test
    public void method5() throws IOException {
        List<User> users = mapperProxy.findByAddress2("安");
        //5.打印输出
        for (User user : users) {
            System.out.println(user);
        }
    }
    @After
    public void after(){
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
    }
}
