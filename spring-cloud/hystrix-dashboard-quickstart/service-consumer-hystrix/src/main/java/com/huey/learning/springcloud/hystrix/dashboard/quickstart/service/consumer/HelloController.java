package com.huey.learning.springcloud.hystrix.dashboard.quickstart.service.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author huey
 */
@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello/{name}")
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://my-service-provider/hello?name=" + name, String.class);
    }

    public String helloFallback(String name) {
        return "Sorry, " + name + "! The service is unavailable.";
    }

}