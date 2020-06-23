package com.demo.ems_thymeleaf.service;

import com.demo.ems_thymeleaf.entity.Emp;
import com.demo.ems_thymeleaf.entity.User;

import java.util.List;

public interface EmpService {
    List<Emp> findAll();

    void save(Emp emp);

    void delete(String id);
}
