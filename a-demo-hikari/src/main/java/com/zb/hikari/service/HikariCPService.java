package com.zb.hikari.service;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class HikariCPService {
    private static final String TEST_SQL = "SELECT * FROM book WHERE id =?";

    @Autowired
    @Qualifier("myHikariDataSource")
    private DataSource dataSource;

    public void connectionDemo1() {
        //getConnection() 方法从连接池中获取一个可用的数据库连接，该方法会首先检查连接池中的空闲连接，如果有则直接返回，若没有空闲连接且连接池未满则创建新连接，
        // 若已满则根据 connectionTimeout 等待或抛出异常。
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(TEST_SQL);
        ) {
            preparedStatement.setInt(1, 24);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("b_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void connectionDemo2() {
        //getConnection() 方法从连接池中获取一个可用的数据库连接，该方法会首先检查连接池中的空闲连接，如果有则直接返回，若没有空闲连接且连接池未满则创建新连接，
        // 若已满则根据 connectionTimeout 等待或抛出异常。
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(TEST_SQL);
            preparedStatement.setInt(1, 24);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("b_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
