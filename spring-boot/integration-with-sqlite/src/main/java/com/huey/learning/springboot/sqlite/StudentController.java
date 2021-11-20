package com.huey.learning.springboot.sqlite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("student/{studId}")
    public Student getStudent(@PathVariable("studId") Long studId) {
        return jdbcTemplate.queryForObject("SELECT * FROM STUDENT WHERE STUD_ID = ?",
                (rs, rowNum) -> {
                    Student student = new Student();
                    student.setStudId(rs.getInt("STUD_ID"));
                    student.setStudName(rs.getString("STUD_NAME"));
                    return student;
                },
                studId);
    }

}