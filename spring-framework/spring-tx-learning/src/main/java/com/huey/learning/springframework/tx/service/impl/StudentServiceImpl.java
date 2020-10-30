package com.huey.learning.springframework.tx.service.impl;

import com.huey.learning.springframework.tx.dao.StudentDao;
import com.huey.learning.springframework.tx.entity.Student;
import com.huey.learning.springframework.tx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional(readOnly = true)
    public Student getStudent(Long studId) {
        return studentDao.getStudent(studId);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

}