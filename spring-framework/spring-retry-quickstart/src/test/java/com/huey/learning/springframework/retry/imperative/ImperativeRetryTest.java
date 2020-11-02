package com.huey.learning.springframework.retry.imperative;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @author huey
 */
@SpringBootTest
@Slf4j
public class ImperativeRetryTest {

    @Autowired
    private RetryTemplate retryTemplate;

    @Test
    public void testRetryTemplate() {

        String result = retryTemplate.execute(new RetryCallback<String, RuntimeException>() {

            @Override
            public String doWithRetry(RetryContext context) throws RestClientException {

                log.info("invoking doWithRetry method.");

//                context.setAttribute("key", "some value");

                String response = new RestTemplate().getForObject("http://example.com/", String.class);

                return response;

            }

        }, new RecoveryCallback<String>() {
            @Override
            public String recover(RetryContext context) throws Exception {

                log.info("invoking recover method.");

                // context.getAttribute("key")
                // context.getRetryCount()
                // context.getLastThrowable()

                return "value from recover";

            }
        });

        // do something with result...
        log.info("get the result from retryTemplate: {}", result);

    }

}
