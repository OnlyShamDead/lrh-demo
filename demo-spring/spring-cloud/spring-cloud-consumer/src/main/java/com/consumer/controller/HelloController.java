package com.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hello")
    public String getHello(String name){
        //访问localhost:8761中注册的provider-hello服务的/ticket请求
        String s = restTemplate.getForObject("http://provider-hello/provider/hello", String.class);
        return s;
    }

}
