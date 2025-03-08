package com.zb.hikari.service;

import com.zb.hikari.entity.User;
import com.zb.hikari.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public User getUserById(Long id) {
    return userMapper.selectById(id);
  }

  public List<User> getAllUsers() {
    return userMapper.selectList(null); // 查询全部
  }
}
