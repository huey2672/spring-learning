package com.huey.learning.springframework.ioc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author huey
 */
@Configuration
@Import({MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class ApplicationConfiguration {

}
