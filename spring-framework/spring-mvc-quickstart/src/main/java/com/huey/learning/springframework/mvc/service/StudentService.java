package com.huey.learning.springframework.mvc.service;

import com.huey.learning.springframework.mvc.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentService {

    public Student getStudent(Long studentId) {
        Student student = new Student();
        student.setStudentId(studentId);
        student.setStudentName("Huey");
        student.setSex("M");
        student.setDateOfBirth(new Date(1218196800000L));
        return student;
    }

}