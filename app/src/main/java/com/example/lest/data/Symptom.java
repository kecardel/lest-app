package com.example.lest.data;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.time.LocalDate;


@Entity(tableName="symptoms")
public class Symptom  {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String date;
    public String symptom;

    public Symptom(String date, String symptom) {
        this.date = date;
        this.symptom = symptom;

    }

    public String getSymptomDate(){return this.date;}
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

