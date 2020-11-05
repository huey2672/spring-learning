package com.huey.learning.springboot.jdbc.jdbcsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class StudentController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("student/{studId}")
    public Student getStudent(@PathVariable("studId") Long studId) {

        String sql = "SELECT * FROM STUDENT WHERE STUD_ID = ?";
        Object[] params = new Object[]{studId};

        return jdbcTemplate.queryForObject(sql, params, new RowMapper<Student>() {

            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setStudId(rs.getInt("STUD_ID"));
                student.setStudName(rs.getString("STUD_NAME"));
                student.setSex(rs.getString("SEX"));
                return student;
            }

        });

    }
}