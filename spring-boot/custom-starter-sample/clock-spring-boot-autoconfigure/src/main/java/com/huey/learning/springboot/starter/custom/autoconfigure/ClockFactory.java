package com.huey.learning.springboot.starter.custom.autoconfigure;

import com.huey.learning.springboot.starter.clocklib.custom.Clock;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author huey
 */
public class ClockFactory {

    private ZoneId zoneId;
    private DateTimeFormatter dateTimeFormatter;

    public ClockFactory(ClockProperties clockProperties) {
        zoneId = ZoneId.of(clockProperties.getZoneId());
        dateTimeFormatter = DateTimeFormatter.ofPattern(clockProperties.getDateTimeFormatterPattern());
    }

    public Clock createClock() {
        return new Clock(zoneId, dateTimeFormatter);
    }

}
