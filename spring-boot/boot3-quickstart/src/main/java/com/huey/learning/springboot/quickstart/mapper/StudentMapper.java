package com.huey.learning.springboot.quickstart.mapper;

import com.huey.learning.springboot.quickstart.entity.Student;

public interface StudentMapper {

    Student getStudentById(Long studId);

}