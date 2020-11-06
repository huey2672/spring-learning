package com.huey.learning.springframework.scheduling.sample.async.quickstart;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
@Service
public class AsyncService {

    @Async
    public void doJob() {

        System.out.println("Start job at " + LocalTime.now());

        try {
            TimeUnit.SECONDS.sleep(3);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finish job at " + LocalTime.now());

    }

}
