package com.zb.hikari.controller;

import com.zb.hikari.service.HikariCPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HikariController {
    @Autowired
    private HikariCPService hikariCPService;

    // http://localhost:8086/hikari-demo/hikari-test1/24
    @GetMapping("hikari-test1/{id}")
    public String hikariTest1(@PathVariable("id") Integer id){
        return "hikari-test1: " + hikariCPService.connectionDemo1(id);
    }

    // http://localhost:8086/hikari-demo/hikari-test2/24
    @GetMapping("hikari-test2/{id}")
    public String hikariTest2(@PathVariable("id") Integer id){
        return "hikari-test2: " + hikariCPService.connectionDemo2(id);
    }

    // http://localhost:8086/hikari-demo/hikari-test-slow-sql/1
    @GetMapping("hikari-test-slow-sql/{time}")
    public String hikariTestSlowSql(@PathVariable("time") Integer time){
        // 起始时间
        long startTime = System.currentTimeMillis();
        hikariCPService.hikariTestSlowSql(time);
        // 结束时间
        long endTime = System.currentTimeMillis();
        // 总耗时
        long totalTime = endTime - startTime;
        return "hikariTestSlowSql, 耗时: " + totalTime + "ms";
    }

//    http://localhost:8086/hikari-demo/book?id=24

//    http://localhost:8086/hikari-demo/book-tdsql?id=24

}
