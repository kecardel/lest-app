package com.example.lest.data;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.Period;
//import java.time.format.DateTimeFormatter;

@Entity(tableName="symptoms")
public class Symptom  {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public Date date;
    public String symptom;

    public Symptom(Date date, String symptom) {
        this.date = date;
        this.symptom = symptom;

    }


    public Date getSymptomDate(){return this.date;}
    public String getSymptomString(){return "\u2022 " + this.symptom;}


    @Override
    public String toString() {
        return "Symptom{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", symptom='" + symptom + '\'' +
                '}';
    }
}
