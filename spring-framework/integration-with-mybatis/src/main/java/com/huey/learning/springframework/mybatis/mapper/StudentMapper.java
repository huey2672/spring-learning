package com.huey.learning.springframework.mybatis.mapper;

import com.huey.learning.springframework.mybatis.entity.Student;

public interface StudentMapper {

    int insertStudent(Student student);

    Student getStudentById(int studId);

}