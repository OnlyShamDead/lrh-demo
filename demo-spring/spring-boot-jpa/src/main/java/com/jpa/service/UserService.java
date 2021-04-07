package com.jpa.service;

import com.jpa.bean.UserDO;

import java.util.List;

public interface UserService {

    public List<UserDO> findAll();

    public UserDO findById(Integer id);

    public UserDO addUser(UserDO userDO);

    public UserDO updateUser(UserDO userDO);

    public void deleteUserById(Integer id);
}
