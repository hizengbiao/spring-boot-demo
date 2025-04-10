package com.zb.hikari.controller;

import com.zb.hikari.service.ManualDsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ManualDsController {
    @Autowired
    private ManualDsService manualDsService;

    // http://localhost:8086/hikari-demo/hikari-manual-ds/get-new-connection
    @GetMapping("hikari-manual-ds/get-new-connection")
    public String getNewConnection(){
        return manualDsService.getNewConnection();
    }


}
