package com.huey.learning.springframework.jdbc.service;

import com.huey.learning.springframework.jdbc.entity.Page;
import com.huey.learning.springframework.jdbc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huey
 */
@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Page<Student> getAllStudentsByPage(int pageNum, int pageSize) {

        return jdbcTemplate.execute(new StatementCallback<Page<Student>>() {

            @Override
            public Page<Student> doInStatement(Statement statement) throws SQLException, DataAccessException {
                Page<Student> studentPage = new Page<>();

                String countSql = "SELECT COUNT(*) AS TOTAL FROM STUDENT";
                ResultSet countRs = statement.executeQuery(countSql);
                while (countRs.next()) {
                    int total = countRs.getInt("TOTAL");
                    studentPage.setTotal(total);
                }

                int page = pageNum > 0 ? pageNum : 1;
                int size = pageSize > 0 ? pageSize : 1;
                int offset = (page - 1) * size;

                String dataSql = "SELECT * FROM STUDENT ORDER BY STUD_ID LIMIT " + offset + "," + size;
                ResultSet dataRs = statement.executeQuery(dataSql);
                List<Student> students = new ArrayList<>();
                while (dataRs.next()) {
                    Student student = new Student();
                    student.setStudId(dataRs.getInt("STUD_ID"));
                    student.setStudName(dataRs.getString("STUD_NAME"));
                    students.add(student);
                }
                studentPage.setResultList(students);

                return studentPage;

            }

        });

    }

}
