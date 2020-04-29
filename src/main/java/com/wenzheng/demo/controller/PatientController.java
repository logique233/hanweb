package com.wenzheng.demo.controller;


import com.wenzheng.demo.service.PatirntService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Resource
    PatirntService patirntService;

    @RequestMapping("/login")
    @PostMapping
    public String patentLogin(){
        //TODO 患者登录
        return "/home";
    }

    @RequestMapping("/registered")
    @PostMapping
    public String patientRegistered() {
        //TODO 患者注册
        return "/home";
    }

    @RequestMapping("/queryGraph")
    @GetMapping
    public String patirntQuaryGraph(){
        //TODO 患者查询知识图谱
        return patirntService.queryGraph();
    }

}
