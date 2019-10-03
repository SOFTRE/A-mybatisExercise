package com.xxM;

import com.xxM.dao.RoleDao;
import com.xxM.domain.Role;
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
    RoleDao mapperProxy;
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
        mapperProxy = sqlSession.getMapper(RoleDao.class);
    }
    @Test
    public void method(){
        List<Role> roleList = mapperProxy.findRoleList();
        for (Role role : roleList) {
            System.out.println(role);
        }

    }
    @After
    public void after(){
        //6.释放资源
        sqlSession.close();
    }
}
