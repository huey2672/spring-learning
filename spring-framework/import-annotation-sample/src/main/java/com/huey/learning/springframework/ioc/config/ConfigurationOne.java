package com.huey.learning.springframework.ioc.config;

import com.huey.learning.springframework.ioc.entity.BeanOne;
import org.springframework.context.annotation.Bean;

/**
 * @author huey
 */
public class ConfigurationOne {

    @Bean
    public BeanOne beanOne() {
        return new BeanOne();
    }

}
