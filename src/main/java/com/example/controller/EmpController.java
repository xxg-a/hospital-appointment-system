package com.example.controller;

import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username,
            @RequestParam String password,
            HttpSession session) {

        Map<String, Object> result = new HashMap<>();
        boolean success = empService.login(username, password);

        if (success) {
            session.setAttribute("loginUser", username);
            result.put("code", 200);
            result.put("msg", "登录成功");
        } else {
            result.put("code", 401);
            result.put("msg", "用户名或密码错误");
        }
        return result;
    }

    @PostMapping("/home")
    public Map<String, Object> home(HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        String username = (String) session.getAttribute("loginUser");

        if (username != null) {
            result.put("code", 200);
            result.put("msg", "欢迎回来，" + username);
        } else {
            result.put("code", 401);
            result.put("msg", "请先登录");
        }
        return result;
    }
}