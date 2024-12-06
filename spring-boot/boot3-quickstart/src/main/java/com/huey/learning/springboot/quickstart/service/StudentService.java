package com.huey.learning.springboot.quickstart.service;

import com.huey.learning.springboot.quickstart.entity.Student;
import com.huey.learning.springboot.quickstart.mapper.StudentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;
    
    public Student getStudent(Long studId) {
        return studentMapper.getStudentById(studId);
    }

}