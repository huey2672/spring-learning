package com.huey.learning.springcloud.eureka.highavailability.service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 *
 * @author huey
 */
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("my-service-provider");
        if (!CollectionUtils.isEmpty(serviceInstanceList)) {
            ServiceInstance serviceInstance = serviceInstanceList.get(0);
            System.out.println("Get a service instance: " + serviceInstance.getUri());

            String result = restTemplate.getForObject(serviceInstance.getUri() + "/hello?name=" + name, String.class);
            return result;

        }

        return "FAILED";

    }

}