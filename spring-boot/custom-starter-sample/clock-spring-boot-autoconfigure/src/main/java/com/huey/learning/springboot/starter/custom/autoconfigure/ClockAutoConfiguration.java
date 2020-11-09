package com.huey.learning.springboot.starter.custom.autoconfigure;

import com.huey.learning.springboot.starter.clocklib.custom.Clock;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author huey
 */
@Configuration
@ConditionalOnClass(Clock.class)
@EnableConfigurationProperties({ClockProperties.class})
@PropertySource("classpath:clock.properties")
public class ClockAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ClockFactory clockFactory(ClockProperties clockProperties) {
        return new ClockFactory(clockProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public Clock clock(ClockFactory clockFactory) {
        return clockFactory.createClock();
    }

}
