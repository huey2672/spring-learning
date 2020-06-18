package com.huey.learning.springcloud.config.highavailability.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAppController {

    @Value("${myapp.description}")
    private String description;

    @RequestMapping("desc")
    public String getDescription() {
        return description;
    }

}