package com.wenzheng.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {



    @RequestMapping("/hello")
    String home() {
        return "Hello ,spring security!";
    }

}