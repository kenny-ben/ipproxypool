package com.spring.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class Config {

	@Bean
	public DruidDataSource druidDataSource(){
		//Druid;数据源配置
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://39.97.234.110:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		//初始连接数（默认值为0）
		dataSource.setInitialSize(8);
		//最小连接数（默认值为0）
		dataSource.setMinIdle(8);
		//最大连接数（默认值为8，注意"maxIdle"这个属性已经弃用）
		dataSource.setMaxActive(32);
		return dataSource;
	}

}
