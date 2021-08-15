package com.example.lest.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class DbRepository {

    private SymptomDao mSymptomDao;
    private LiveData<List<Symptom>> mAllSymptoms;

    DbRepository(Application application) {
        LestDatabase db = LestDatabase.getDatabase(application);
        mSymptomDao = db.symptomDao();
        mAllSymptoms = mSymptomDao.getAll();
    }

    LiveData<List<Symptom>> getAllSymptoms() {
        return mAllSymptoms;
    }

    void insert(Symptom symptom) {
        LestDatabase.databaseWriteExecutor.execute(() -> {
            mSymptomDao.insertSymptom(symptom);
        });
    }
}
