package com.example.lest.data;

import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverter;

import java.util.Date;

@ProvidedTypeConverter
public class Converters {
    @TypeConverter
    public Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }
}
