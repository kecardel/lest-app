package com.example.lest.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SymptomDao {
    @Insert
    void insertSymptom(Symptom symptom);

    @Query("SELECT * FROM symptoms ORDER BY date DESC")
    LiveData<List<Symptom>> getAll();

}
