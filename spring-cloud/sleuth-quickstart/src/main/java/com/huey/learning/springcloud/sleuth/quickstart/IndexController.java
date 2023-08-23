package com.huey.learning.springcloud.sleuth.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        log.info("Hello, World!");
        return "Hello, World!";
    }

}
