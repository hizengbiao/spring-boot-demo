package com.zb.hikari.controller;

import com.zb.hikari.entity.User;
import com.zb.hikari.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

//  http://localhost:8086/hikari-demo/api/users/1
  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable Long id) {
    User user = userService.getUserById(id);
    if(user != null){
      return ResponseEntity.ok(user);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

//  http://localhost:8086/hikari-demo/api/users
  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }
}
