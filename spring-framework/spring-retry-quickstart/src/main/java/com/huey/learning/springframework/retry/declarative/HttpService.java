package com.huey.learning.springframework.retry.declarative;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class HttpService {

    @Retryable(include = {RestClientException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 5000))
    public String httpGet(String url) {
        log.info("Invoking httpGet.");
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }

    @Recover
    public String httpGet(RestClientException e, String url) {
        log.error("Failed to GET HTTP request for " + url, e);
        return "Not Found";
    }

}
