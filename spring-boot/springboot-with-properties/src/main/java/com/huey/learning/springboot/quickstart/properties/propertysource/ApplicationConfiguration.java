package com.huey.learning.springboot.quickstart.properties.propertysource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author huey
 */
@Configuration
@PropertySource("classpath:config/jdbc.properties")
@PropertySource("classpath:config/cache.properties")
public class ApplicationConfiguration {
}
