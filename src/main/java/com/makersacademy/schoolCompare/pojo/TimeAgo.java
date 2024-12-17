package com.makersacademy.schoolcompare.pojo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class TimeAgo {
    public static String calculate(LocalDateTime momentInThePast) {
        Duration duration = Duration.between(momentInThePast, LocalDateTime.now());
        long minutes = duration.toMinutes();
        long days = duration.toDays();

        if (minutes < 1) {
            return "just now";
        } else if (minutes < 60) {
            return minutes + "m ago";
        } else if (minutes < 1440) { // less than 24h ago
            return (minutes / 60) + "h ago";
        } else if (minutes < 2880) {
            return "yesterday";
        } else if (minutes < 10080) { // less than a week ago
            String createdDay = momentInThePast.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
            return "on " + createdDay;
        } else {
            int createdDay = momentInThePast.getDayOfMonth();
            String createdMonth = momentInThePast.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
            return "on " + createdDay + " " + createdMonth;
        }
    }
}
