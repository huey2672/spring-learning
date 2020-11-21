package com.huey.learning.springframework.ioc;

import com.huey.learning.springframework.ioc.config.ApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author huey
 */
public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();

        Arrays.stream(beanNames).forEach(
                System.out::println
        );

    }

}
