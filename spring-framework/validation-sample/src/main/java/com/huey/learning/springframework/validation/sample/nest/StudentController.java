package com.huey.learning.springframework.validation.sample.nest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @PostMapping("/saveStudent")
    ResponseEntity<String> saveStudent(@Validated @RequestBody Student student) {
        // do something with student
        return ResponseEntity.ok("Student is valid");
    }

}
