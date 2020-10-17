package com.huey.learning.spring.ioc.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huey
 */
@Configuration
public class ServiceConfiguration {

    @Bean
    public HelloService helloService() {
        return new HelloService();
    }

}
