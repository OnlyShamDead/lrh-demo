package com.jpa.dao;

import com.jpa.bean.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface  UserDAO extends JpaRepository<UserDO, Integer> {

}
