package com.zb.hikari.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyHikariDataSourceConfig {

//    @Bean(name = "myHikariDataSource")
//    public DataSource dataSource(MyHikariConfig myHikariConfig) {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(myHikariConfig.getJdbcUrl());
//        config.setUsername(myHikariConfig.getUsername());
//        config.setPassword(myHikariConfig.getPassword());
//        config.setMaximumPoolSize(myHikariConfig.getMaximumPoolSize());
//        config.setMinimumIdle(myHikariConfig.getMinimumIdle());
//        config.setIdleTimeout(myHikariConfig.getIdleTimeout());
//        config.setConnectionTimeout(myHikariConfig.getConnectionTimeout());
//        config.setMaxLifetime(myHikariConfig.getMaxLifetime());
//        config.setKeepaliveTime(myHikariConfig.getKeepaliveTime());
//        return new HikariDataSource(config);
//    }
}
