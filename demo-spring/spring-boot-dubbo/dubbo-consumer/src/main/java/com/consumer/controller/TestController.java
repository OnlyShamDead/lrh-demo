package com.consumer.controller;

import com.common.dubbo.bo.UserBO;
import com.common.dubbo.service.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class TestController {

    @Reference
    DubboService dubboService;

    @RequestMapping(value = "/test")
    public UserBO test() {
        System.out.println(dubboService);
        return dubboService.info();
    }
}
