package com.huey.learning.springboot.quickstart.properties;

import com.huey.learning.springboot.quickstart.properties.enableconfigurationproperties.AnotherJdbcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(AnotherJdbcConfiguration.class)
@SpringBootApplication
public class SpringbootWithPropertiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWithPropertiesApplication.class, args);
    }

}
