package com.huey.learning.springframework.aop.pointcut.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author huey
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ApplicationConfiguration {
}
