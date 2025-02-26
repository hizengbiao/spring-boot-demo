package com.zb.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomTomcatListener implements ApplicationListener<ApplicationStartingEvent> {

    @Value("${custom.simulateDeadlock:false}")
    private boolean simulateDeadlock;

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        if (simulateDeadlock) {
            System.out.println("Tomcat initialized with port(s):");
            // 停止启动流程，模拟假死状态
            Thread.currentThread().suspend(); // 请注意，这只是模拟，不推荐在生产环境使用
        }
    }
}
