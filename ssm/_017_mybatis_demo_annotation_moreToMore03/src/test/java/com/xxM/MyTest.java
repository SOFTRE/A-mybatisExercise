package com.xxM;

import com.xxM.dao.AccountMapper;
import com.xxM.domain.Account;
import com.xxM.domain.User;
import lombok.Data;
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
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-03 11:17:48 周四
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class MyTest {
    InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    AccountMapper accountMapper;

    @Before
    public void before() throws IOException {
        String resource = "SqlMapConfig.xml";
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    @Test
    public void method() {
        User user=new User();
        user.setUsername("上海");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("北京");
        Integer integer = accountMapper.addUser(user);
        System.out.println(user);
        System.out.println(integer);
        System.out.println("===================================");
        Integer delete = accountMapper.delete(55);
        System.out.println(delete);
        System.out.println("===================================");
        User user1=accountMapper.fingById(56);
        user1.setUsername("王者峡谷");
        user1.setSex("女");
        user1.setAddress("lol");
        user1.setBirthday(new Date());
        Integer integer1;
        integer1 = accountMapper.updateUser(user1);
        System.out.println(integer1);
        System.out.println("===================================");
        List<User> userList = accountMapper.findUserList();
        for (User user2 : userList) {
            System.out.println(user2);
        }
        System.out.println("===================================");
        Account account = accountMapper.findAccount(1);
        System.out.println(account);
        System.out.println(account.getUser());
    }

    @After
    public void after() {
        if (inputStream!=null){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
