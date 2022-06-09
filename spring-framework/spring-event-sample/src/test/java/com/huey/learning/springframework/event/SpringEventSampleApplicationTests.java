package com.huey.learning.springframework.event;

import com.huey.learning.springframework.event.custom.CustomSpringEventPublisher;
import com.huey.learning.springframework.event.generic.GenericStringSpringEventPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringEventSampleApplicationTests {

    @Resource
    CustomSpringEventPublisher customSpringEventPublisher;

    @Resource
    GenericStringSpringEventPublisher genericSpringEventPublisher;

    @Test
    void testPublishCustomEvent() {
        customSpringEventPublisher.publishCustomEvent("Hello, World");
    }

    @Test
    void testPublishGenericEvent() {
        genericSpringEventPublisher.publishGenericEvent("Hello, World");
    }

}
