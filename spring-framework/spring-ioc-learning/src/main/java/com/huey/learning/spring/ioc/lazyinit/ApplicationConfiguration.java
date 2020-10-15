package com.huey.learning.spring.ioc.lazyinit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @author huey
 */
public class ApplicationConfiguration {

    @Bean
    @Lazy
    public ExampleBean exampleBean() {
        return new ExampleBean();
    }

}
