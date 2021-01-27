package com.huey.learning.springboot.quickstart.properties.maven;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author huey
 */
@RestController
@ConfigurationProperties("maven")
@Data
public class MavenPlaceholderController {

    private Map<String, String> properties;

    @GetMapping("maven/properties")
    public Map<String, String> mavenProperties() {
        return properties;
    }

}
