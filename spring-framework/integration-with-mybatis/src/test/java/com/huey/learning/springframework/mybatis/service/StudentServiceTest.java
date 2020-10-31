package com.huey.learning.springframework.mybatis.service;

import com.huey.learning.springframework.mybatis.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentServiceTest {

    @Test
    public void testAddStudent() {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentService = appCtx.getBean(StudentService.class);

        Student student = new Student();
        student.setStudId(1001);
        student.setStudName("huey");
        student.setSex("M");
        studentService.addStudent(student);

    }

    @Test
    public void testGetStudentById() {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentService = appCtx.getBean(StudentService.class);

        Student student = studentService.getStudentById(1001);
        System.out.println(student);

    }

}