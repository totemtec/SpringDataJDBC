package com.example.sum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMAT = "yyyyMMdd";

    public static long parseDate(String dateString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(dateString, formatter);
        ZonedDateTime zonedDateTime = date.atStartOfDay(ZoneId.of("Asia/Shanghai"));
        return zonedDateTime.toInstant().getEpochSecond()*1000;
    }

    public static String formatString(long timeMillis, String pattern) {
        Date date = new Date(timeMillis);
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(date);
    }

    public static String getToday(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(date);
    }

    public static long todayMidnight() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfToday = LocalDateTime.of(today, LocalTime.MIDNIGHT);
        ZonedDateTime dateTime = startOfToday.atZone(ZoneId.of("Asia/Shanghai"));
        long value = dateTime.toInstant().getEpochSecond();
        return value * 1000;
    }
}
