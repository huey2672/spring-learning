package com.huey.learning.springboot.starter.clocklib.custom;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author huey
 */
public class Clock {

    private ZoneId zoneId;

    private DateTimeFormatter dateTimeFormatter;

    public Clock(ZoneId zoneId, DateTimeFormatter dateTimeFormatter) {
        this.zoneId = zoneId;
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public String now() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        return zonedDateTime.format(dateTimeFormatter);
    }

}
