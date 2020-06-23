package com.demo.ems_thymeleaf.dao;

import com.demo.ems_thymeleaf.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    void save(User user);

    User login(@Param("username")String username,@Param("password")String password);
}
