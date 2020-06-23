package com.demo.ems_thymeleaf.dao;

import com.demo.ems_thymeleaf.entity.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> findAll();

    void save(Emp emp);

    void delete(String id);

}
