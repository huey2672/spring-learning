package com.huey.learning.springboot.webmvcconfigurer.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huey
 */
@Slf4j
@RestController
public class MyController {

    @GetMapping("/api/hello")
    public String hello() {
        log.info("Hello, World!");
        return "Hello, World!";
    }

}
