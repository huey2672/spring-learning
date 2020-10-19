package com.huey.learning.spring.ioc.propertysource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author huey
 */
@Configuration
@PropertySource("classpath:propertysource/application.properties")
public class ApplicationConfiguration {

    @Bean
    public ExampleBean exampleBean(@Value("${app.example.val}") String fieldValue) {
        return new ExampleBean(fieldValue);
    }

}
