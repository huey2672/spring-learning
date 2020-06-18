package com.huey.learning.springcloud.ribbon.quickstart.service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {

        ServiceInstance serviceInstance = loadBalancerClient.choose("my-service-provider");
        System.out.println("Get a service instance: " + serviceInstance.getPort());

        return new RestTemplate().getForObject(serviceInstance.getUri() + "/hello?name=" + name, String.class);

    }

}