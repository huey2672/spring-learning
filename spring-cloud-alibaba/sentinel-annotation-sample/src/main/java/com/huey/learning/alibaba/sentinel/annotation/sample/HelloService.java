package com.huey.learning.alibaba.sentinel.annotation.sample;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * @author huey
 */
@Service
public class HelloService {

    @SentinelResource(value = "sayHello", blockHandler = "sayHelloBlocked", fallback = "sayHelloFallback")
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }

    public String sayHelloBlocked(String name, BlockException e) {
        return "BLOCKED by " + e.getClass().getSimpleName() + "!";
    }

    public String sayHelloFallback(String name, Throwable t) {
        return "ERROR by " + t.getClass().getSimpleName() + "!";
    }

}
