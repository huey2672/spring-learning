package com.huey.learning.spring.ioc.importannotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author huey
 */
@Configuration
@Import({ServiceConfiguration.class, DaoConfiguration.class})
public class ApplicationConfiguration {

}
