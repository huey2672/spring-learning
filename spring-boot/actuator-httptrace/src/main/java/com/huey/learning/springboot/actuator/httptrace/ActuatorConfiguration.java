package com.huey.learning.springboot.actuator.httptrace;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huey
 */
@Configuration
public class ActuatorConfiguration {

    @Bean
    public HttpTraceRepository httpTraceRepository() {
        //        return new InMemoryHttpTraceRepository();
        return new CustomTraceRepository();
    }

}
