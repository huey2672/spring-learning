package com.huey.learning.springframework.scheduling.sample.async.quickstart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalTime;

/**
 * @author huey
 */
public class AsyncSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AsyncConfiguration.class);
        AsyncService asyncService = appCtx.getBean(AsyncService.class);

        System.out.println("T1: " + LocalTime.now());
        asyncService.doJob();
        System.out.println("T2: " + LocalTime.now());

    }

}
