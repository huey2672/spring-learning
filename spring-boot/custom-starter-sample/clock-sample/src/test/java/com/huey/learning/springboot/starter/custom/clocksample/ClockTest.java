package com.huey.learning.springboot.starter.custom.clocksample;

import com.huey.learning.springboot.starter.clocklib.custom.Clock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huey
 */
@SpringBootTest
public class ClockTest {

    @Autowired
    private Clock clock;

    @Test
    public void testNow() {
        System.out.println("Get current time from clock: " + clock.now());
    }

}
