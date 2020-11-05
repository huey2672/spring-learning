package com.huey.learning.springboot.jdbc.mybatis.integration.service;

import com.huey.learning.springboot.jdbc.mybatis.integration.entity.Student;
import com.huey.learning.springboot.jdbc.mybatis.integration.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;
    
    public Student getStudent(Long studId) {
        return studentMapper.getStudentById(studId);
    }

}