package com.huey.learning.springframework.scheduling.sample.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * @author huey
 */
@Service
public class SchedulingService {

    @Scheduled(initialDelay = 3000, fixedRate = 5000)
    public void simpleJob() {
        System.out.println("Invoke simpleJob at " + LocalTime.now());
    }

    @Scheduled(cron = "0/10 * * * * ?")
    public void cronJob() {
        System.out.println("Invoke cronJob at " + LocalTime.now());
    }

}
