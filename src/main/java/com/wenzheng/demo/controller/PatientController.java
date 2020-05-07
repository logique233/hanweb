package com.wenzheng.demo.controller;


import com.wenzheng.demo.entity.User;
import com.wenzheng.demo.service.PatirntService;
import com.wenzheng.demo.util.R;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Resource
    PatirntService patirntService;

    @RequestMapping("/loginView")
    @GetMapping
    public String patentLoginview(){
        //TODO 患者登录
        return "patient_login";
    }

    @RequestMapping("/queryGraph")
    @GetMapping
    public String patentqueryGraph(){
        //TODO 患者登录
        return "patient_graph";
    }

    @RequestMapping("/login")
    @PostMapping
    @ResponseBody
    public ResponseEntity<R<User>> patentLogin(String name, String password,HttpServletResponse response){
        //TODO 患者登录
        R<User> result = new R<User>();
        try {
//            patirntService.login();
            User user = patirntService.login(name, password);
            if (user != null) {
                result.code=200;
                result.data = user;
                Cookie cookieID = new Cookie("ID", user.getId());
                Cookie cookieStatus = new Cookie("STATUS", user.getStatus());
                cookieID.setMaxAge(7 * 24 * 60 * 60);
                cookieID.setHttpOnly(true);
                cookieID.setPath("/");
                cookieStatus.setMaxAge(7 * 24 * 60 * 60);
                cookieStatus.setHttpOnly(true);
                cookieStatus.setPath("/");
                response.addCookie(cookieID);
                response.addCookie(cookieStatus);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<R<User>>(result, HttpStatus.OK);
    }


    @RequestMapping({"/index","/"})
    @PostMapping
    public String patentIndex(){
        //TODO 患者登录
        return "patientindex";
    }

    @RequestMapping("/registered")
    @PostMapping
    @ResponseBody
    public R<User> patientRegistered(User user) {
        //TODO 患者注册
        R<User> result = new R<User>();
        try {

            patirntService.registerted(user);
            result.code = 200;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



    @RequestMapping("/queryStatus")
    @GetMapping
    @ResponseBody
    public ResponseEntity<R<String>> patirntQuaryStatus(String ID, HttpServletResponse response){
        //TODO 患者查询知识图谱
        R<String> result = new R<String>();
        try {
            String status = patirntService.GetStatus(ID);
            result.code = 200;
            result.data = status;
            Cookie cookie = new Cookie("STATUS", status);
            cookie.setMaxAge(7 * 24 * 60 * 60);
//            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
            result.code = 500;
        }
        return new ResponseEntity<R<String>>(result, HttpStatus.OK);
    }

    @RequestMapping("/SetStatus")
    @GetMapping
    @ResponseBody
    public R<String> patirntSetStatus(String ID,String Status,HttpServletResponse response){
        //TODO 患者查询知识图谱
        R<String> result = new R<String>();
        try {
            if (patirntService.SetStatus(ID, Status, new Date())>0);
            {
                result.code = 200;
                Cookie cookie = new Cookie("STATUS", Status);
                cookie.setMaxAge(7 * 24 * 60 * 60);
//            cookie.setSecure(true);
                cookie.setHttpOnly(true);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.code = 500;
        }
        return result;
    }

    @RequestMapping("/GetAll")
    @GetMapping
    @ResponseBody
    public R<List<User>> patirntGetAll(int page,int limit){
        //TODO 患者查询知识图谱
        R<List<User>> result = new R<List<User>>();
        try {
            Pageable pageable = PageRequest.of(page-1,limit);
            Page<User> users = patirntService.GetAll(pageable);
            List<User> userList = users.getContent();
            result.data = userList;
            result.code = 0;
            result.count = (int) users.getTotalElements();
        } catch (Exception e) {
            e.printStackTrace();
            result.code = 500;
        }
        return result;
    }

}
