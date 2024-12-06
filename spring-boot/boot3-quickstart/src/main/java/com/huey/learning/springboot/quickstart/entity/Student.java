package com.huey.learning.springboot.quickstart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer studId;

    private String studName;

    private String sex;

}