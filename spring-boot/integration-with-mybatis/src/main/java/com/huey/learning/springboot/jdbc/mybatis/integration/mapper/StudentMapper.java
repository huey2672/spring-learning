package com.huey.learning.springboot.jdbc.mybatis.integration.mapper;

import com.huey.learning.springboot.jdbc.mybatis.integration.entity.Student;

public interface StudentMapper {

    Student getStudentById(Long studId);

}