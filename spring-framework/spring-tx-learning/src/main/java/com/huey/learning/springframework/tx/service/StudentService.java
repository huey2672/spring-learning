package com.huey.learning.springframework.tx.service;

import com.huey.learning.springframework.tx.entity.Student;

public interface StudentService {

    Student getStudent(Long studId);

    void addStudent(Student student);

}