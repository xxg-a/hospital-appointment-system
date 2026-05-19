package com.example.service;

import com.example.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface EmpService {

    // 核心逻辑：查库密码 vs 输入密码
    public boolean login(String username, String password) ;
}