package com.huey.learning.springframework.scheduling.sample.scheduling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author huey
 */
public class SchedulingSample {

    public static void main(String[] args) throws IOException {

        new AnnotationConfigApplicationContext(SchedulingConfiguration.class);

    }

}
