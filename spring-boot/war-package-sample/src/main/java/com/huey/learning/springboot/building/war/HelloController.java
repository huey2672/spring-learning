package com.huey.learning.springboot.building.war;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huey
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String sayHello() {
        return "Hello, World!";
    }

}
