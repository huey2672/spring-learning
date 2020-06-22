package com.huey.learning.springcloud.hystrix.quickstart.service.consumer;

import org.springframework.stereotype.Component;

/**
 * @author huey
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String hello(String name) {
        return "Sorry, " + name + "! The service is unavailable.";
    }

}
