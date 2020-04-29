package com.wenzheng.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PatirntService {

    public String login() {
        return "患者登录";
    }

    public String registerted() {
        return "患者注册";
    }

    public String queryGraph() {
        return "查询图谱";
    }
}
