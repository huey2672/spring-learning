package com.huey.learning.springcloud.hystrix.quickstart.service.provider;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huey
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(@RequestParam String name) {
        return "Hello, " + StringUtils.capitalize(name) + "!";
    }
    
}