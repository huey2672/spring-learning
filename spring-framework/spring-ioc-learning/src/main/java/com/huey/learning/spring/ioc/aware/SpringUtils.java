package com.huey.learning.spring.ioc.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author huey
 */
public final class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return applicationContext.getBean(name, requiredType);
    }

    public static <T> T getBean(Class<T> requiredType) throws BeansException {
        return applicationContext.getBean(requiredType);
    }

    public static String getProperty(String key) {
        return applicationContext.getEnvironment().getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return applicationContext.getEnvironment().getProperty(key, defaultValue);
    }

    // ...

}