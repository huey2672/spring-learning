package com.huey.learning.springcloud.fegin.quickstart.service.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "my-service-provider")
public interface HelloRemote {

    @RequestMapping("/hello")
    String hello(@RequestParam("name") String name);

}