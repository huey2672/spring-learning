package com.huey.learning.springframework.tx.dao;

import com.huey.learning.springframework.tx.entity.Student;

public interface StudentDao {

    Student getStudent(Long studId);

    void addStudent(Student student);

}
