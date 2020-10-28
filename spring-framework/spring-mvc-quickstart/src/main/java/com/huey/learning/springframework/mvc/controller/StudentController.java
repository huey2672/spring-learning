package com.huey.learning.springframework.mvc.controller;

import com.huey.learning.springframework.mvc.entity.Student;
import com.huey.learning.springframework.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/studentInfo")
    public ModelAndView getStudent(Long studentId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("studentView");
        Student student = studentService.getStudent(studentId);
        mav.addObject(student);
        return mav;
    }

}