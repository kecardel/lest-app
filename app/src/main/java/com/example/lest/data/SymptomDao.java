package com.example.lest.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SymptomDao {
    @Insert
    public void insertSymptom(Symptom symptom);

    @Query("SELECT * FROM symptoms")
    LiveData<List<Symptom>> getAll();

    @Query("SELECT * FROM symptoms")
    List<Symptom> getAllSynchronous();
}
