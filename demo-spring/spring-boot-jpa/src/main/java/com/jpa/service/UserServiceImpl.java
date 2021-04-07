package com.jpa.service;

import com.jpa.bean.UserDO;
import com.jpa.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public List<UserDO> findAll() {
        return userDAO.findAll();
    }

    @Override
    public UserDO findById(Integer id) {
        return userDAO.findById(id).get();
    }

    @Override
    public UserDO addUser(UserDO userDO) {
        return userDAO.save(userDO);
    }

    @Override
    public UserDO updateUser(UserDO userDO) {
        return userDAO.save(userDO);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDAO.deleteById(id);
    }

}
