package com.zb.hikari.controller;

import com.zb.hikari.service.HikariCPService;
import com.zb.hikari.service.HikariCPSysCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * strace -f -tt -T -o strace.log java -jar diagnose-zb-demo-db-connection-hikari.jar
 *
 * strace -f -tt -T -o strace.log -p  <PID>
 *  -f：递归跟踪该进程及其所有子进程的系统调用
 *
 * @author
 * @date 2025/3/3
 */

@RestController
public class HikariSysCallController {
    @Autowired
    private HikariCPSysCallService hikariCPSysCallService;
    @Autowired
    private HikariCPService hikariCPService;

    // http://localhost:8086/hikari-demo/hikari-sys-call/exec-sql/24
    @GetMapping("hikari-sys-call/exec-sql/{id}")
    public String hikariTest1(@PathVariable("id") Integer id){
        return hikariCPService.connectionDemo1(id);
    }

    // http://localhost:8086/hikari-demo/hikari-sys-call/get-new-connection
    @GetMapping("hikari-sys-call/get-new-connection")
    public String getNewConnection(){
        return hikariCPSysCallService.getNewConnection();
    }


}
