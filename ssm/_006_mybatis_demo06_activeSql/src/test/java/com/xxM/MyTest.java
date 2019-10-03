package com.xxM;

import com.xxM.dao.UserMapper;
import com.xxM.domain.User;
import com.xxM.domain.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
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
    public void method(){
        QueryVo queryVo=new QueryVo();
        User user=new User();
        //user.setUsername("北");
        user.setAddress("北");
        Integer [] arr={10,11,12};
        queryVo.setAds(Arrays.asList(arr));
        queryVo.setUser(user);
        List<User> byQueryVo = mapperProxy.findByQueryVo(queryVo);
        for (User user1 : byQueryVo) {
            System.out.println(user1);
        }
    }
    @After
    public void after(){
        //6.释放资源
        sqlSession.close();
    }
}
