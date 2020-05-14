package com.wenzheng.demo.controller;


import com.wenzheng.demo.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    AdminService adminService;

    @RequestMapping("/home")
    public String productInfo() {
        return "index";
    }

    @RequestMapping("/base")
    public String base() {
        return "base";
    }

    @RequestMapping("/patient")
    @GetMapping
    public String patient() {
        return "user_index";
    }

    @RequestMapping("/patientList")
    @GetMapping
    public String patientList() {
        //TODO 输出患者列表
        return adminService.patientList();
    }

    @RequestMapping("/patientTrack")
    @GetMapping
    public String patientTrack() {
        //TODO 输出患者轨迹
        return "adminService.patientTrack()";
    }

    @RequestMapping("/setGraph")
    @PutMapping
    public String setGraph() {
        //TODO 设置知识图谱
        return "set_graph";
    }

    @RequestMapping("quaryGraph")
    @GetMapping
    public String quaryGraph() {
        //TODO 查询知识图谱
        return adminService.quarygraph();
    }

    @RequestMapping("login")
    @GetMapping
    public String login() {
        //TODO 查询知识图谱
        return "login";
    }


}
