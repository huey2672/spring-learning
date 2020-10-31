package com.huey.learning.springframework.mybatis.service;

import com.huey.learning.springframework.mybatis.entity.Student;
import com.huey.learning.springframework.mybatis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public void addStudent(Student student) {
        studentMapper.insertStudent(student);
    }

    public Student getStudentById(int studId) {
        return studentMapper.getStudentById(studId);
    }

}