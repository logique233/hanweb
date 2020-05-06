package com.wenzheng.demo.controller;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientControllerTest {
    @Autowired
    com.wenzheng.demo.dal.modeRepository modeRepository;
    @Test
    void test() {
        System.out.println(modeRepository.findByName("结束"));
//        HashMap<String, Object> result = modeSerivice.getModeGraph("结束");
//        result.get("node").toString();
    }


}