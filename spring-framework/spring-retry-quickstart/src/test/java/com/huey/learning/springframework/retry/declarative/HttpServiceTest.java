package com.huey.learning.springframework.retry.declarative;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huey
 */
@SpringBootTest
@Slf4j
public class HttpServiceTest {

    @Autowired
    HttpService httpService;

    @Test
    public void testHttpService() {

        String result = httpService.httpGet("http://example.com/");
        log.info("result: {}", result);

    }

}
