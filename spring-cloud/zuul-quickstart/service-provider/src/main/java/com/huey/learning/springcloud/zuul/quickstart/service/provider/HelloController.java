package com.huey.learning.springcloud.zuul.quickstart.service.provider;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huey
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private Integer serverPort;

    @RequestMapping("/hello")
    public String sayHello(@RequestParam String name) {
        return "Hello, " + StringUtils.capitalize(name) + "! I am from " + serverPort + ".";
    }

}