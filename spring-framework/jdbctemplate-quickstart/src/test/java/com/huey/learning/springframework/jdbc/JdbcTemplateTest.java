package com.huey.learning.springframework.jdbc;

import com.huey.learning.springframework.jdbc.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateTest {

    @Test
    public void testJdbcTemplate() {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = appCtx.getBean(JdbcTemplate.class);

        String sql = "CREATE TABLE STUDENT ( "
                + "STUD_ID INT(10) PRIMARY KEY, "
                + "STUD_NAME VARCHAR(16), SEX CHAR(1)"
                + ")";
        jdbcTemplate.execute(sql);

    }

    @Test
    public void testInsert() {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = appCtx.getBean(JdbcTemplate.class);

        String sql = "INSERT INTO STUDENT(STUD_ID, STUD_NAME, SEX) VALUES(?, ?, ?)";
        Object[] params = new Object[]{1001, "huey", "M"};
        jdbcTemplate.update(sql, params);

    }

    @Test
    public void testUpdate() {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = appCtx.getBean(JdbcTemplate.class);

        String sql = "UPDATE STUDENT SET STUD_NAME = ? WHERE STUD_ID = ?";
        Object[] params = new Object[]{"Huey", 1001};
        jdbcTemplate.update(sql, params);

    }

    @Test
    public void testDelete() {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = appCtx.getBean(JdbcTemplate.class);

        String sql = "DELETE FROM STUDENT WHERE STUD_ID = ?";
        Object[] params = new Object[]{1001};
        jdbcTemplate.update(sql, params);

    }

    @Test
    public void testQueryForObject() {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = appCtx.getBean(JdbcTemplate.class);

        String sql = "SELECT * FROM STUDENT WHERE STUD_ID = ?";
        Object[] params = new Object[]{1001};
        Student student = jdbcTemplate.queryForObject(sql, params, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setStudId(rs.getInt("STUD_ID"));
                student.setStudName(rs.getString("STUD_NAME"));
                student.setSex(rs.getString("SEX"));
                return student;
            }
        });

        System.out.println(student);

    }

    @Test
    public void testQueryForList() {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = appCtx.getBean(JdbcTemplate.class);

        String sql = "SELECT * FROM STUDENT WHERE SEX = ?";
        Object[] params = new Object[]{"M"};
        List<Student> students = jdbcTemplate.query(sql, params, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setStudId(rs.getInt("STUD_ID"));
                student.setStudName(rs.getString("STUD_NAME"));
                student.setSex(rs.getString("SEX"));
                return student;
            }
        });
        System.out.println(students);

    }

    @Test
    public void testMultipleSQL() {

        int offset = 0;
        int size = 1;

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = appCtx.getBean(JdbcTemplate.class);

        String sql1 = "SELECT COUNT(*) AS TOTAL FROM STUDENT";
        Long total = (Long) jdbcTemplate.queryForMap(sql1).get("TOTAL");

        String sql2 = "SELECT * FROM STUDENT ORDER BY STUD_ID LIMIT " + offset + "," + size;
        List<Student> students = jdbcTemplate.query(sql2, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setStudId(rs.getInt("STUD_ID"));
                student.setStudName(rs.getString("STUD_NAME"));
                student.setSex(rs.getString("SEX"));
                return student;
            }
        });

        System.out.println("total: " + total);
        System.out.println("students: " + students);

    }

}