package com.huey.learning.springframework.tx.dao.impl;

import com.huey.learning.springframework.tx.dao.StudentDao;
import com.huey.learning.springframework.tx.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Student getStudent(Long studId) {
        String sql = "SELECT STUD_ID, `NAME`, EMAIL, PHONE, DOB FROM STUDENTS T WHERE T.STUD_ID = ?";
        Student student = jdbcTemplate.queryForObject(sql, new Object[]{studId}, Student.class);
        return student;
    }

    @Override
    public void addStudent(Student student) {

        String sql = "INSERT INTO STUDENTS(STUD_ID, `NAME`, EMAIL, PHONE) VALUES(?, ?, ?, ?)";
        Object[] params = new Object[]{student.getStudId(), student.getName(), student.getEmail(), student.getPhone()};
        jdbcTemplate.update(sql, params);

        //
        jdbcTemplate.update(sql, params);

    }

}
