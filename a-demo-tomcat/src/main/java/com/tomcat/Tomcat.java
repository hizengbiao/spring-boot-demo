package com.tomcat;

import com.tomcat.services.SocketProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-03-31 22:24
 */
@SpringBootApplication
public class Tomcat {

    public void start() {
        // Socket连接 TCP

        try {
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            ServerSocket serverSocket = new ServerSocket(8081);
            while(true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new SocketProcessor(socket));
            }
//            InputStream inputStream = socket.getInputStream();
//            socket.getOutputStream().write(1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        SpringApplication.run(Tomcat.class, args);
        Tomcat tomcat = new Tomcat();
        tomcat.start();


    }

}

