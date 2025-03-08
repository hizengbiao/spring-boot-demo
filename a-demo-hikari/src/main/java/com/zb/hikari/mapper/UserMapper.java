package com.zb.hikari.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zb.hikari.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
  // 继承MyBatis Plus的BaseMapper即拥有基础CRUD方法


  /***
   CREATE TABLE IF NOT EXISTS t_user (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(50) NOT NULL,
   email VARCHAR(100),
   create_time DATETIME DEFAULT CURRENT_TIMESTAMP
   );

   INSERT INTO t_user (name, email) VALUES
   ('Alice', 'alice@example.com'),
   ('Bob', 'bob@example.com');
   */
}
