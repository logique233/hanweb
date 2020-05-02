package com.wenzheng.demo.service;

import com.wenzheng.demo.dal.UserRepository;
import com.wenzheng.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class PatirntServiceTest {

    @Autowired
    private PatirntService patirntService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void login() {
    }

    @Test
    void registerted() {
        for (int i = 0; i < 30; i++) {
            User user = new User();
            user.setUsername("李四"+i);
            user.setPassword("1234weret"+i);
            user.setCity("天津"+i);
            user.setEmail("129asd3@123.com");
            user.setSex("女");
            user.setStatus("化验"+i);
            user.setSignature("李四"+i);
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());
            patirntService.registerted(user);
        }

    }

    @Test
    void change() {
        Pageable pageable = PageRequest.of(0,5);
        Page<User> all = userRepository.findAll(pageable);
        System.out.println(all.getTotalElements());
    }

}