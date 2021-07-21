package com.huey.learning.nacos.discovery.springcloud.quickstart.serviceconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://service-provider/hello?name=" + name, String.class);
    }

}