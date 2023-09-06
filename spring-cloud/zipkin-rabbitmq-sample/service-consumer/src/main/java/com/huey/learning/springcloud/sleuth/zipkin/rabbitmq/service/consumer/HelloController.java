package com.huey.learning.springcloud.sleuth.zipkin.rabbitmq.service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class HelloController {
    
    @Resource
    private HelloRemote helloRemote;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        log.info("Hello, {}!", name);
        return helloRemote.hello(name);
    }
    
}