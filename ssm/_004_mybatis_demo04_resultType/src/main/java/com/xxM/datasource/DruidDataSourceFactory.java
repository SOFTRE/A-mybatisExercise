package com.xxM.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * @Program: IntelliJ IDEA ssm
 * @Description: transform the datasource
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-09-28 13:51:56 周六
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class DruidDataSourceFactory extends UnpooledDataSourceFactory {
    public DruidDataSourceFactory(){
        this.dataSource=new DruidDataSource();
    }
}
