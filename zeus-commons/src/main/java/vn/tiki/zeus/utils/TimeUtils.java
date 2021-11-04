package vn.tiki.zeus.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class TimeUtils {
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime mySqlTime(String time) {
        if (time == null || time.isBlank()) return null;
        return LocalDateTime.parse(time, DATETIME_FORMATTER);
    }

    public static String time(LocalDateTime time) {
        return time(time, DATETIME_FORMATTER);
    }

    public static String time(LocalDateTime time, DateTimeFormatter formatter) {
        if (time == null) return null;
        try {
            return formatter.format(time);
        } catch (Exception e) {
            log.error("Cannot get current time in format ", e);
            return null;
        }
    }
}
