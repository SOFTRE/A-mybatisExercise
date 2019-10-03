package com.xxM;

import com.xxM.dao.UserMapper;
import com.xxM.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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
    @Test
    public void method() throws IOException {
        //1. 读取SqlMapConfig.xml获得输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        is.close();
        //3. 获得SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.通过namespace.id调用
        UserMapper mapperProxy = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapperProxy.findAll();
        //5.打印输出
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
    }
}
