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
public class HiController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi/{name}")
    @HystrixCommand(fallbackMethod = "hiFallback")
    public String hi(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://my-service-provider/hi?name=" + name, String.class);
    }

    public String hiFallback(String name) {
        return "Sorry, " + name + "! The <hi> service is unavailable.";
    }

}