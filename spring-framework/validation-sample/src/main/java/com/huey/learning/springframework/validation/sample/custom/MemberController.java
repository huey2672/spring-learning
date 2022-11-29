package com.huey.learning.springframework.validation.sample.custom;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @PostMapping("/saveMember")
    ResponseEntity<String> saveMember(@Validated @RequestBody Member member) {
        // do something with member
        return ResponseEntity.ok("Member is valid");
    }

}
