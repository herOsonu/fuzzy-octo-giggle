package com.demo.ems_thymeleaf.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    //durd基本属性设置
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        return new DruidDataSource();
    }
}
