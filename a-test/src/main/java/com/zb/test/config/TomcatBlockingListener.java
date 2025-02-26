package com.zb.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TomcatBlockingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${custom.simulateDeadlock:false}")
    private boolean simulateDeadlock;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext() instanceof ServletWebServerApplicationContext) {
            if (simulateDeadlock) {
                // 检测到Tomcat初始化完成后，无限阻塞主线程
                System.out.println("Application has initialized but not started with port(s)");
                // 检测到Tomcat初始化完成后，无限阻塞主线程
                while (true) {
                    try {
                        Thread.sleep(Long.MAX_VALUE);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
