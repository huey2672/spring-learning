package com.huey.learning.spring.ioc.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author huey
 */
@Configuration
public class ApplicationConfiguration {

    @Bean(name = "dataSource")
    @Profile("dev")
    public ExampleBean getDevExampleBean() {
        return new ExampleBean("DevelopmentBean");
    }

    @Bean(name = "dataSource")
    @Profile("test")
    public ExampleBean getTestExampleBean() {
        return new ExampleBean("TestBean");
    }

}
