package com.huey.learning.springboot.swagger2.integration.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Greet Service")
@RestController
public class GreetController {

    @GetMapping("/hello")
    @ApiOperation("Say Hello")
    public String hello(@ApiParam("Name") String name) {
        return "Hello, " + name + "!";
    }

}