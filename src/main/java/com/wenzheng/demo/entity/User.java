package com.wenzheng.demo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_user")
@Data

public class User {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "idGenerator")
    private String id;

    @Column(name = "username", nullable = false, length = 64)
    private String username;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "city", length = 10)
    private String city;

    @Column(name = "sex")
    private String sex;

    @Column(name = "signature", length = 5)
    private String signature;

    @Column(name = "status", length = 5)
    private String status;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date updateTime;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createTime;


}

