package com.huey.learning.springboot.quickstart;

import com.huey.learning.springboot.quickstart.entity.Student;
import com.huey.learning.springboot.quickstart.service.HelloService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("hello")
    public Student hello(Integer studId) {
        Student student = new Student(1, "Huey", "M");
        redisTemplate.opsForValue().set("student:" + studId, student.getStudName());
        return student;
    }

}
