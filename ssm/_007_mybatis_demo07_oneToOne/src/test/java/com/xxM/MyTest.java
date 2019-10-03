package com.xxM;

import com.xxM.dao.AccountDao;
import com.xxM.domain.Account02;
import com.xxM.domain.AccountCustom;
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
    AccountDao mapperProxy;
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
        mapperProxy = sqlSession.getMapper(AccountDao.class);
    }
    @Test
    public void method(){
        List<AccountCustom> accountList = mapperProxy.findAccountList();
        for (AccountCustom accountCustom : accountList) {
            System.out.println(accountCustom);
        }
    }
    @Test
    public void method2(){
        List<Account02> accountList = mapperProxy.findAccountList02();
        for (Account02 account02 : accountList) {
            System.out.println(account02);
        }
    }
    @After
    public void after(){
        //6.释放资源
        sqlSession.close();
    }
}
