package com.example.lest.data;


import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

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

//    private String mSymptom;
//    public Symptom(@NonNull String symptom) {this.mSymptom = symptom;}
    public String getSymptom(){return this.symptom;}

    @Override
    public String toString() {
        return "Symptom{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", symptom='" + symptom + '\'' +
                '}';
    }
}
