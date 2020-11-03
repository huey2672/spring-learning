package com.huey.learning.springboot.quickstart.properties.nested;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author huey
 */
@Slf4j
@Data
@Component
@ConfigurationProperties("mail")
public class MailConfiguration {

    private String hostname;
    private int port;
    private String from;
    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;
    private Credentials credentials;

    @PostConstruct
    public void init() {
        log.info("Initializing: {}", this);
    }

}
