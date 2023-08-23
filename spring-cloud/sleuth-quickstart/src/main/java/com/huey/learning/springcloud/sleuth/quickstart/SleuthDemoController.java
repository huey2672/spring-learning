package com.huey.learning.springcloud.sleuth.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

@Slf4j
@RestController
public class SleuthDemoController {

    @Resource
    private SleuthService sleuthService;

    @Resource
    private Executor executor;

    @GetMapping("/")
    public String index() {
        log.info("Hello, World!");
        return "Hello, World!";
    }

    @GetMapping("/sameSpanSample")
    public String sameSpanSample() throws Exception {
        log.info("Same Span");
        sleuthService.doSomeWorkSameSpan();
        return "success";
    }

    @GetMapping("/newSpanSample")
    public String newSpanSample() throws Exception {
        log.info("New Span");
        sleuthService.doSomeWorkNewSpan();
        return "success";
    }

    @GetMapping("/newThreadSample")
    public String newThreadSample() {

        log.info("New Thread");

        Runnable runnable = () -> {
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("I'm inside the new thread - with a new span");
        };
        executor.execute(runnable);

        log.info("I'm done - with the original span");
        return "success";

    }

    @GetMapping("/asyncSample")
    public String asyncSample() throws Exception {
        log.info("Before Async Method Call");
        sleuthService.asyncMethod();
        log.info("After Async Method Call");
        return "success";
    }

}
