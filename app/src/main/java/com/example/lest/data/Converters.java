package com.example.lest.data;

import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverter;

import java.time.LocalDate;
import java.util.Date;

@ProvidedTypeConverter
public class Converters {
    @TypeConverter
    public static LocalDate fromLocalDate(String value) {
        return value == null ? null : LocalDate.parse(new String(value));
    }
    @TypeConverter
    public static String dateToTimestamp(LocalDate date) {
        return date == null ? null : String.valueOf(LocalDate.now());
    }

}
