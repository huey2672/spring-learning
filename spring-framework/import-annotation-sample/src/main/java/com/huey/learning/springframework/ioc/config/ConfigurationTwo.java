package com.huey.learning.springframework.ioc.config;

import com.huey.learning.springframework.ioc.entity.BeanTwo;
import org.springframework.context.annotation.Bean;

/**
 * @author huey
 */
public class ConfigurationTwo {

    @Bean
    public BeanTwo beanTwo() {
        return new BeanTwo();
    }

}
