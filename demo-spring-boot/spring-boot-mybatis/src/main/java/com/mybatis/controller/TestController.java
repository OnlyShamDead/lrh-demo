package com.mybatis.controller;

import com.mybatis.dao.mapper.UserPoMapper;
import com.mybatis.dao.pojo.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybatis")
public class TestController {

    @RequestMapping(value = "/xx")
    public String xx() {

        return "xxxxx";
    }

}
