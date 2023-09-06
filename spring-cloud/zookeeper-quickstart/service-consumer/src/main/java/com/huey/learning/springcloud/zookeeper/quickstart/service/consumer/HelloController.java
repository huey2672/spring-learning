package com.huey.learning.springcloud.zookeeper.quickstart.service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class HelloController {

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("my-service-provider");
        if (CollectionUtils.isEmpty(serviceInstanceList)) {
            return "FAILED";
        }

        ServiceInstance serviceInstance = serviceInstanceList.get(0);
        log.info("Get a service instance: {}", serviceInstance.getUri());
        return restTemplate.getForObject(serviceInstance.getUri() + "/hello?name=" + name, String.class);

    }

}