package com.huey.learning.springcloud.hystrix.quickstart.service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author huey
 */
@RestController
public class HelloController {

    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {

        return helloRemote.hello(name);

    }

}