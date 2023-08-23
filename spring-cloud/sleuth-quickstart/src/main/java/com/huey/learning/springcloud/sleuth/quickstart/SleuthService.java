package com.huey.learning.springcloud.sleuth.quickstart;

import brave.Span;
import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SleuthService {

    @Resource
    private Tracer tracer;

    public void doSomeWorkSameSpan() throws InterruptedException {
        Thread.sleep(1000L);
        log.info("Doing some work");
    }

    public void doSomeWorkNewSpan() throws InterruptedException {

        log.info("I'm in the original span");

        Span newSpan = tracer.nextSpan().name("newSpan").start();
        try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
            Thread.sleep(1000L);
            log.info("I'm in the new span doing some cool work that needs its own span");
        }
        finally {
            newSpan.finish();
        }

        log.info("I'm in the original span");

    }

    @Async("executor")
    public void asyncMethod() throws InterruptedException {
        log.info("Start Async Method");
        Thread.sleep(1000L);
        log.info("End Async Method");
    }

    public void getTraceIdAndSpanId() {
        Span span = tracer.currentSpan();
        String traceId = span.context().traceIdString();
        String spanId = span.context().spanIdString();
        String parentId = span.context().parentIdString();
    }

}
