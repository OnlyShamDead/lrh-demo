package com.jpa.service;

import com.jpa.bean.UserDO;

import java.util.List;

public interface UserService {

    public List<UserDO> findAll();

    public UserDO findById(Integer id);
}
