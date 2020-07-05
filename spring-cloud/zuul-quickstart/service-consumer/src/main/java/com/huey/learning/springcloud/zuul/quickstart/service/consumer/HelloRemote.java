package com.huey.learning.springcloud.zuul.quickstart.service.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "my-zuul-gateway")
public interface HelloRemote {

    @RequestMapping("/my-service-provider/hello")
    String hello(@RequestParam("name") String name);

}