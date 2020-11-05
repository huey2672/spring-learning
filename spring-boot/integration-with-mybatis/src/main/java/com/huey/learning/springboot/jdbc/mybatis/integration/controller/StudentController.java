package com.huey.learning.springboot.jdbc.mybatis.integration.controller;

import com.huey.learning.springboot.jdbc.mybatis.integration.entity.Student;
import com.huey.learning.springboot.jdbc.mybatis.integration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/{studId}")
    public Student getStudent(@PathVariable("studId") Long studId) {
        return studentService.getStudent(studId);
    }

}