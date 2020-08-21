package com.hello.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/getHello/{name}")
    public String getHello(@PathVariable String name) {
        return name + ": Hello World!";
    }
}
