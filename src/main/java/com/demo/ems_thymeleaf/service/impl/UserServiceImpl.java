package com.demo.ems_thymeleaf.service.impl;

import com.demo.ems_thymeleaf.dao.UserDao;
import com.demo.ems_thymeleaf.entity.User;
import com.demo.ems_thymeleaf.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public void register(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.save(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}
