package com.huey.learning.springframework.validation.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/users")
    ResponseEntity<String> addUser(@Validated @RequestBody User user) {
        // do something with user
        return ResponseEntity.ok("User is valid");
    }

}