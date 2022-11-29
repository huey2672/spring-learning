package com.huey.learning.springframework.validation.sample.group;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class StudentController {

    @PostMapping("/addStudent")
    ResponseEntity<String> addStudent(@Validated(Add.class) @RequestBody Student student) {
        // do something with student
        return ResponseEntity.ok("Student is valid");
    }

    @PostMapping("/updateStudent")
    ResponseEntity<String> updateStudent(@Validated(Update.class) @RequestBody Student student) {
        // do something with student
        return ResponseEntity.ok("Student is valid");
    }

}
