package com.example.lest.data;

import android.app.Application;

import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

public class LogViewModel extends AndroidViewModel {

    private DbRepository mRepository;
    private LiveData<List<Symptom>> mAllSymptoms;
    private LiveData<List<List<Symptom>>> groupedSymptoms;

    public LogViewModel(Application application) {
        super(application);
        mRepository = new DbRepository(application);

//        Each item in the list is a list of symptoms for a particular day.
        groupedSymptoms = Transformations.map( mAllSymptoms, (Function<List<Symptom>, List<List<Symptom>>>) input -> {
            return null;
        });
    }

}
