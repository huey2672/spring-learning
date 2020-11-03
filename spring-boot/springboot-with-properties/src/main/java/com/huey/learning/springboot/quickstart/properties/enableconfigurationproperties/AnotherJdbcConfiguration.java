package com.huey.learning.springboot.quickstart.properties.enableconfigurationproperties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Data
@ConfigurationProperties("jdbc")
public class AnotherJdbcConfiguration {

    private String driver;

    private String url;

    private String username;

    private String password;

    @PostConstruct
    public void init() {
        log.info("Initializing: {}", this);
    }

}