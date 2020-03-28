package ru.lifestrim.mvvm_test.utils;

import androidx.room.TypeConverter;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    public static String getDayMonth(Date date) {
        SimpleDateFormat dayFormat =  new SimpleDateFormat("dd");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
        String day = dayFormat.format(date);
        String monthString = monthFormat.format(date);
        return day + monthString;
    }
}
