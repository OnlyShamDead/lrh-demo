package com.mybatis.controller;

import com.mybatis.dao.mapper.UserPoMapper;
import com.mybatis.dao.pojo.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserPoMapper userPoMapper;

    @RequestMapping(value = "/xx")
    public String xx() {

        return "xxxxx";
    }

    @RequestMapping(value = "/ss")
    public UserPo ss() {

        return userPoMapper.selectByPrimaryKey(1);
    }

}
