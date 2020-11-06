package com.huey.learning.springframework.scheduling.sample.async.future;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
public class AsyncFutrueSample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AsyncFutureConfiguration.class);
        FutureService futureService = appCtx.getBean(FutureService.class);

        Future<LocalDateTime> future = futureService.doJob();

        while (true) {

            if (future.isDone()) {
                System.out.println("Get result from async service: " + future.get());
                break;
            }

            System.out.println("Wait. " + LocalDateTime.now());
            TimeUnit.SECONDS.sleep(1);

        }

    }

}
