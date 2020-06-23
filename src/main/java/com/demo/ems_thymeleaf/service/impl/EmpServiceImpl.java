package com.demo.ems_thymeleaf.service.impl;

import com.demo.ems_thymeleaf.dao.EmpDao;
import com.demo.ems_thymeleaf.entity.Emp;
import com.demo.ems_thymeleaf.entity.User;
import com.demo.ems_thymeleaf.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpDao empDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> findAll() {
        return empDao.findAll();
    }

    @Override
    public void save(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDao.save(emp);
    }

    @Override
    public void delete(String id) {
        empDao.delete(id);
    }
}
