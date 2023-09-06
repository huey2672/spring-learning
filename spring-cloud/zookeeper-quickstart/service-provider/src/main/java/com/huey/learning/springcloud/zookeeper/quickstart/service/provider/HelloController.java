package com.huey.learning.springcloud.zookeeper.quickstart.service.provider;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(@RequestParam String name) {
        return "Hello, " + StringUtils.capitalize(name) + "!";
    }

}