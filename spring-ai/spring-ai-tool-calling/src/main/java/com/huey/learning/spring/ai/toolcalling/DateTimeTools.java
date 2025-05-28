package com.huey.learning.spring.ai.toolcalling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
class DateTimeTools {

    @Tool(description = "获取用户所在时区中的当前日期和时间")
    String getCurrentDateTime() {
        String currentDateTime = LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
        log.info("当前日期时间: {}", currentDateTime);
        return currentDateTime;
    }

    @Tool(description = "设置指定时间的闹钟，以 ISO-8601 格式提供")
    void setAlarm(String time) {
        log.info("结束参数：{}", time);
        LocalDateTime alarmTime = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME);
        log.info("设置闹钟：{}", alarmTime);
    }

}
