package com.tomcat.services;

import com.tomcat.bean.Request;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class SocketProcessor implements Runnable{
    private static final Logger log = Logger.getLogger(SocketProcessor.class.getName());
    private Socket socket;

    public SocketProcessor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        processSocket(socket);
    }

    private void processSocket(Socket socket) {
        // 处理Socket连接，读数据、写数据
        log.info("processSocket start");

        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            inputStream.read(bytes);
//            log.info("processSocket read: " + new String(bytes));
            Request request = new Request("GET", "/index.html", "HTTP/1.1");
            // 匹配Servlet，执行doGet/doPost方法
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
