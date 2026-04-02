package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pojo.Emp;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public boolean login(String username, String password) {
        String dbPassword = empMapper.findPasswordByUsername(username);
        if (dbPassword == null) {
            return false; // 用户名不存在
        }
        return dbPassword.equals(password);
    }
}