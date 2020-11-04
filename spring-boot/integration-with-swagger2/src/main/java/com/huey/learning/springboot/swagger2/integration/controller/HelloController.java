package com.huey.learning.springboot.swagger2.integration.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Hello Controller")
@RestController
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation("Say Hello")
    public String hello() {
        return "Hello, Swagger2!";
    }

}