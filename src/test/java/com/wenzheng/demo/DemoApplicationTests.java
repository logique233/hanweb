package com.wenzheng.demo;

import com.wenzheng.demo.dal.modeRepository;
import com.wenzheng.demo.entity.mode;
import com.wenzheng.demo.service.modeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    com.wenzheng.demo.service.modeService modeService;

    @Autowired
    modeRepository modeRepository;

    @Test
    void contextLoads() {
        HashMap<String, Object> modeGraph = modeService.getModeGraph("挂号");
        modeGraph.toString();
    }

}
