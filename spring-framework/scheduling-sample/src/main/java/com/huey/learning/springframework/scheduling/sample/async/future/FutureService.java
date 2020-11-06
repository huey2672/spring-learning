package com.huey.learning.springframework.scheduling.sample.async.future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
@Service
public class FutureService {

    @Async
    public Future<LocalDateTime> doJob() {

        LocalDateTime time = LocalDateTime.now();

        try {
            TimeUnit.SECONDS.sleep(3);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new AsyncResult<>(time);

    }

}
