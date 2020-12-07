package com.jpa.controller;

import com.jpa.bean.UserDO;
import com.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUser")
    public List<UserDO> getUser() {

        List<UserDO> userDOS = userService.findAll();

        //UserDO ud = userService.findById(1);


        return userDOS;
    }
}
