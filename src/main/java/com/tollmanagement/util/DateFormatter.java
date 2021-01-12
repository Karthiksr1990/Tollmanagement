package com.tollmanagement.util;

import java.util.Calendar;
import java.util.Date;

public class DateFormatter {

    public static Date getPresentDate() {
        // today
        Calendar date = Calendar.getInstance();
        // reset hour, minutes, seconds and millis
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date.getTime();
    }

    public static Date getFutureDate(Date oldDate, int days) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();

    }

    public static Date getPreviousDate(int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, -hours);
        return calendar.getTime();
    }
}
