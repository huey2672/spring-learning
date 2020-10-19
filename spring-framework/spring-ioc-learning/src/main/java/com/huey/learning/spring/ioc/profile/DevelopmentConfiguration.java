package com.huey.learning.spring.ioc.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author huey
 */
@Configuration
@Profile("development")
public class DevelopmentConfiguration {

    @Bean
    public ExampleBean exampleBean() {
        return new ExampleBean("DevelopmentBean");
    }

}
