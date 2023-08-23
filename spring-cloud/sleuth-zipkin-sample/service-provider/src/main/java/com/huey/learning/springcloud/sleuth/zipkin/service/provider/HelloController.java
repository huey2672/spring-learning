package com.huey.learning.springcloud.sleuth.zipkin.service.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(@RequestParam String name) {
        log.info("Hello, {}!", StringUtils.capitalize(name));
        return "Hello, " + StringUtils.capitalize(name) + "!";
    }

}