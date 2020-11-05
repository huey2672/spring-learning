package com.huey.learning.springboot.data.redis.integration.controller;

import com.huey.learning.springboot.data.redis.integration.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huey
 */
@RestController
public class StudentController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("student/{studId}")
    public Student getStudent(@PathVariable("studId") Integer studId) {

        Student student = new Student(studId, "Huey", "M");

        redisTemplate.opsForValue().set("student::" + studId, student);

        return student;

    }

}
