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

    @RequestMapping(value = "/addUser")
    public UserDO addUser() {
        UserDO userDO = new UserDO();
        userDO.setName("test");
        userDO.setSex(1);
        userDO.setOpenId("xxxxxxxxxxxxxx");
        return userService.addUser(userDO);
    }

    @RequestMapping(value = "/getUser")
    public List<UserDO> getUser() {
        List<UserDO> userDOS = userService.findAll();
        //UserDO ud = userService.findById(1);
        return userDOS;
    }

    @RequestMapping(value = "/updateUser")
    public UserDO updateUser() {
        UserDO userDO = new UserDO();
        userDO.setMainId(2);
        userDO.setName("2222222222222222");
        userDO.setSex(2);
        userDO.setOpenId("sssssssssssssssssss");
        return userService.updateUser(userDO);
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser() {
        userService.deleteUserById(2);
        return "delete success!";
    }
}
