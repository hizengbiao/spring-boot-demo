package com.zb.hikari.controller;

import com.zb.hikari.service.HikariCPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HikariController {
    @Autowired
    private HikariCPService hikariCPService;

    @GetMapping("hikari-test1")
    public String hikariTest1(){
        hikariCPService.connectionDemo1();
        return "hikari-test1";
    }

    @GetMapping("hikari-test2")
    public String hikariTest2(){
        hikariCPService.connectionDemo2();
        return "hikari-test2";
    }
}
