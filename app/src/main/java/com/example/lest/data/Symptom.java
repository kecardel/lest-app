package com.example.lest.data;


import android.widget.EditText;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName="symptoms")
public class Symptom  {
    @PrimaryKey
    public int id;

    public Date date;
    public String symptom;

    public Symptom(Date date, String symptom) {
        this.date = date;
        this.symptom = symptom;
    }

    @Override
    public String toString() {
        return "Symptom{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", symptom='" + symptom + '\'' +
                '}';
    }
}
