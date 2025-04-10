package com.zb.hikari.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MultiDataSourceConfig {

//    // 指定默认数据源 (可选)
//    @Primary
//    @Bean(name = "dataSource")
//    public DataSource dataSource() {
//        return tomcatDataSource(); // 默认使用 Tomcat-JDBC
//    }
//
//    // 1. 配置 HikariCP 数据源
//    @Bean(name = "hikariDataSource")
////    @Primary
//    @ConfigurationProperties(prefix = "hikari.datasource")
//    public DataSource hikariDataSource() {
//        return new HikariDataSource();
//    }
//
//    // 2. 配置 Druid 数据源
//    @Bean(name = "druidDataSource")
//    @ConfigurationProperties(prefix = "druid.datasource")
//    public DataSource druidDataSource() {
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    // 3. 配置 Tomcat-JDBC 数据源
//    @Bean(name = "tomcatDataSource")
//    @ConfigurationProperties(prefix = "tomcat.datasource")
//    public DataSource tomcatDataSource() {
//        org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
//        ds.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState");
//        return ds;
//    }
}
