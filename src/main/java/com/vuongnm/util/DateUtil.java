package com.vuongnm.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String formatInstant(Instant instant, ZoneId zone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(zone);
        return formatter.format(instant);
    }
}
