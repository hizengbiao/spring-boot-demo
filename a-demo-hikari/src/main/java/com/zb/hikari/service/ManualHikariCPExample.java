package com.zb.hikari.service;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * 手动构造有参的hikariCP数据库连接池
 */
@Service
public class ManualHikariCPExample {

//    public static void connectionDemo1(HikariConfig config) {
//        //HikariDataSource 是连接池的实际管理类，它接收 HikariConfig 作为配置信息并创建和管理连接池。
//        HikariDataSource dataSource = new HikariDataSource(config);
//
//        //getConnection() 方法从连接池中获取一个可用的数据库连接，该方法会首先检查连接池中的空闲连接，如果有则直接返回，若没有空闲连接且连接池未满则创建新连接，
//        // 若已满则根据 connectionTimeout 等待或抛出异常。
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book WHERE id =?");
//        ) {
//            preparedStatement.setInt(1, 24);
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    System.out.println(resultSet.getString("b_name"));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            dataSource.close();
//        }
//    }
//
//    public static void connectionDemo2(HikariConfig config) {
//        //HikariDataSource 是连接池的实际管理类，它接收 HikariConfig 作为配置信息并创建和管理连接池。
//        HikariDataSource dataSource = new HikariDataSource(config);
//
//        //getConnection() 方法从连接池中获取一个可用的数据库连接，该方法会首先检查连接池中的空闲连接，如果有则直接返回，若没有空闲连接且连接池未满则创建新连接，
//        // 若已满则根据 connectionTimeout 等待或抛出异常。
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = dataSource.getConnection();
//            preparedStatement = connection.prepareStatement("SELECT * FROM book WHERE id =?");
//            preparedStatement.setInt(1, 24);
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    System.out.println(resultSet.getString("b_name"));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
//            dataSource.close();
//        }
//    }
//
//    public static void main(String[] args) {
//        // 配置 HikariCP 连接池
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost:3307/test?passwordCharacterEncoding=latin1&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useUnicode=true&useSSL=false&connectTimeout=10000&socketTimeout=600000&allowPublicKeyRetrieval=true");
//        config.setUsername("root");
//        config.setPassword("982003834");
//        config.setMaximumPoolSize(10);
//        config.setMinimumIdle(5);
//        config.setIdleTimeout(30000);
//        config.setConnectionTimeout(5000);
//        config.setMaxLifetime(1800000);
//        config.setKeepaliveTime(90000);
//
//        connectionDemo1(config);
//    }
}
