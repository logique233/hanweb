package com.wenzheng.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public String patientList(){
        return "输出患者列表";
    }

    public String patientTrack(){
        return "输出患者轨迹";
    }

    public String setGraph() {
        return "设置知识图谱";
    }

    public String quarygraph() {
        return "查询知识图谱";
    }
}

