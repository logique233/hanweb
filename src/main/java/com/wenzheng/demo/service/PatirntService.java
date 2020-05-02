package com.wenzheng.demo.service;

import com.wenzheng.demo.dal.UserRepository;
import com.wenzheng.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PatirntService {

    @Autowired
    UserRepository userRepository;

    public User login(String name, String password) {
        return userRepository.findByUsernameAndPassword(name,password);
    }

    public void registerted(User user) {
         userRepository.save(user);
    }

    public int SetStatus(String Id, String Status, Date date) {
         return userRepository.updateStatusById(Id, Status, date);
    }

    public String GetStatus(String ID) {
        return userRepository.findStatusById(ID);
    }

    public Page<User> GetAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public long Count() {
        return userRepository.count();
    }
}
