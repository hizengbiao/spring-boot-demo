package com.zb.hikari.controller;

import com.zb.hikari.entity.UrlReqBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/call")
@Slf4j
public class CallController {
    @Autowired
    private RestTemplate restTemplate;

//  curl http://localhost:8086/hikari-demo/api/call/call-url
// curl --request POST --url http://localhost:8086/hikari-demo/api/call/call-url --header 'content-type: application/json' --data '{"url": "http://localhost:8086/hikari-demo/health-check"}'
    @PostMapping("/call-url")
    public String sendRequest(@RequestBody UrlReqBody urlReqBody) {
        log.info("url:{}", urlReqBody.getUrl());
        String result = restTemplate.getForObject(urlReqBody.getUrl(), String.class);
        log.info("result:{}", result);
        return result;
    }
}
