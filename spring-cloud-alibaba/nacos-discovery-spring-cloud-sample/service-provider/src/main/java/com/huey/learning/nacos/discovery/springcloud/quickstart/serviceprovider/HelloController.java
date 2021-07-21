package com.huey.learning.nacos.discovery.springcloud.quickstart.serviceprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }

}