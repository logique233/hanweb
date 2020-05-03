package com.wenzheng.demo.controller;

import com.wenzheng.demo.dal.IKGraphRepository;
import com.wenzheng.demo.query.GraphQuery;
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
    IKGraphRepository ikGraphRepository;

    @Test
    void test() {
        GraphQuery query = new GraphQuery();
        query.setNodename("取药");
        HashMap<String, Object> stringObjectHashMap = ikGraphRepository.getalldomaingraphMode(query);
        System.out.println(stringObjectHashMap.toString());
    }


}