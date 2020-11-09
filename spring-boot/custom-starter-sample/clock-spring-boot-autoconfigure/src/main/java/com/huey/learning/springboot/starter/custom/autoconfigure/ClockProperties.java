package com.huey.learning.springboot.starter.custom.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author huey
 */
@ConfigurationProperties(prefix = ClockProperties.CLOCK_PREFIX)
public class ClockProperties {

    public static final String CLOCK_PREFIX = "clock";

    private String zoneId;
    private String dateTimeFormatterPattern;

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getDateTimeFormatterPattern() {
        return dateTimeFormatterPattern;
    }

    public void setDateTimeFormatterPattern(String dateTimeFormatterPattern) {
        this.dateTimeFormatterPattern = dateTimeFormatterPattern;
    }

}
