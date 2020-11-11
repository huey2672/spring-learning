package com.huey.learning.springboot.web.filter.filtersample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huey
 */
@RestController
public class HelloController {


    @GetMapping("/service/hello")
    public String sayHello() {
        return "Hello, World!";
    }

}
