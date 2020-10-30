package com.huey.learning.springframework.tx.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {

    private Long studId;
    private String name;
    private String email;
    private String phone;
    private Date dob;
    private String status;

}