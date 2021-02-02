package com.huey.learning.springboot.actuator.httptrace;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CustomTraceRepository implements HttpTraceRepository {

    AtomicReference<HttpTrace> lastTrace = new AtomicReference<>();

    @Override
    public List<HttpTrace> findAll() {
        return Collections.singletonList(lastTrace.get());
    }

    @Override
    public void add(HttpTrace trace) {
        lastTrace.set(trace);
    }

}