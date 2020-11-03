package com.huey.learning.springboot.quickstart.properties.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huey
 */
@RestController
public class EnvironmentController {

    @Autowired
    private Environment environment;

    @GetMapping("env")
    public String getEnv(String key) {
        return environment.getProperty(key);
    }

}
