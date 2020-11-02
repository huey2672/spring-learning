package com.huey.learning.springframework.retry.imperative;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author huey
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public RetryTemplate retryTemplate() {

        RetryTemplate retryTemplate = new RetryTemplate();

        // 固定次数的重试策略，设置最大调用次数为 3 次，即最多重试 2 次
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(3);
        retryTemplate.setRetryPolicy(retryPolicy);

        // 固定时间的退避策略，设置时间间隔为 5 秒
        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(5000L);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        return retryTemplate;

    }

}
