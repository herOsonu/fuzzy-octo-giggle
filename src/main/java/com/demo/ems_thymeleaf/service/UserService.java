package com.demo.ems_thymeleaf.service;

import com.demo.ems_thymeleaf.entity.User;

public interface UserService {
    void register(User user);

    User login(String username,String password);
}
