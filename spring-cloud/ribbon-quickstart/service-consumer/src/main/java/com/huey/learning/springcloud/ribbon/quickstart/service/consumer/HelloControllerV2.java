package com.huey.learning.springcloud.ribbon.quickstart.service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloControllerV2 {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello/v2/{name}")
    public String hello(@PathVariable("name") String name) {

        return restTemplate.getForObject("http://my-service-provider/hello?name=" + name, String.class);

    }

}