package com.huey.learning.springboot.web.httpmessageconvertersample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @author huey
 */
@RestController
public class StudentController {

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable("studentId") Long studentId) {
        return new Student(studentId, "Huey", LocalDate.of(2008, 8, 8));
    }

}
