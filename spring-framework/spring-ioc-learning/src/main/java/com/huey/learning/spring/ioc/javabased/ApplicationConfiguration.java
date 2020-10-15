package com.huey.learning.spring.ioc.javabased;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author huey
 */
@Configuration
@ComponentScan(basePackages = "com.huey.learning.spring.ioc.javabased")
public class ApplicationConfiguration {

    @Bean
    public HelloComponent helloComponent() {
        return new HelloComponent();
    }

    @Bean
    public HelloService helloService(@Qualifier("helloComponent") HelloComponent helloComponent) {
        return new HelloService(helloComponent);
    }

}
