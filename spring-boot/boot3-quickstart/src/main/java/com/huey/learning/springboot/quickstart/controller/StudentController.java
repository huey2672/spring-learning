package com.huey.learning.springboot.quickstart.controller;

import com.huey.learning.springboot.quickstart.entity.Student;
import com.huey.learning.springboot.quickstart.service.StudentService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServlet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("getStudent")
    public Student getStudent(Long studId) {
        return studentService.getStudent(studId);
    }

}
