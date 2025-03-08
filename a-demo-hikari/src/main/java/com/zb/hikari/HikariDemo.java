package com.zb.hikari;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-03-31 22:24
 */
@SpringBootApplication
@MapperScan("com.zb.hikari.mapper")
public class HikariDemo {

    public static void main(String[] args) {
        SpringApplication.run(HikariDemo.class, args);
    }

}

