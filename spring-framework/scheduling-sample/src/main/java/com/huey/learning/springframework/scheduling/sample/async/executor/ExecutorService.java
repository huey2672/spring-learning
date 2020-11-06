package com.huey.learning.springframework.scheduling.sample.async.executor;

import org.springframework.scheduling.annotation.Async;

/**
 * @author huey
 */
public class ExecutorService {

    @Async("threadPoolTaskExecutor")
    public void doJob() {

        System.out.println("Hello, World!");

    }

}
