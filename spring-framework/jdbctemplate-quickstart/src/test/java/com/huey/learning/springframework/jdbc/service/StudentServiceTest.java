package com.huey.learning.springframework.jdbc.service;

import com.huey.learning.springframework.jdbc.entity.Page;
import com.huey.learning.springframework.jdbc.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class StudentServiceTest {

    @Test
    public void testGetAllStudentsByPage() {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentService = appCtx.getBean(StudentService.class);

        Page<Student> studentPage = studentService.getAllStudentsByPage(1, 10);
        System.out.println(studentPage);

    }

}
