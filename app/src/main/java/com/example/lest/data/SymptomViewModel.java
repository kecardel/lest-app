package com.example.lest.data;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SymptomViewModel extends AndroidViewModel {
    private DbRepository mRepository;

    private final LiveData<List<Symptom>> mAllSymptoms;
    private MutableLiveData<String> currentDateString = new MutableLiveData<>("");

    private String currentSymptom = "";
    private Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d");

    public SymptomViewModel(Application application) {
        super(application);
        mRepository = new DbRepository(application);
        mAllSymptoms = mRepository.getAllSymptoms();
        initializeWithTodaysDate();
    }

    public LiveData<String> getCurrentDateLiveData() {
        return currentDateString;
    }

    private void initializeWithTodaysDate() {
        currentDateString.setValue(dateFormat.format(Calendar.getInstance().getTime()));
    }

    public void onDatePickerSubmitted(int year, int month, int day) {
        Calendar updatedCalendar = Calendar.getInstance();
        updatedCalendar.set(Calendar.YEAR, year);
        updatedCalendar.set(Calendar.MONTH, month);
        updatedCalendar.set(Calendar.DAY_OF_MONTH, day);
        currentDate = updatedCalendar.getTime();
        currentDateString.setValue(dateFormat.format(updatedCalendar.getTime()));
    }

    public void onSymptomTextChanged(String symptom) {
        currentSymptom = symptom;
    }

    public void logSymptom() {
        // interact with DbRepository here
        Symptom addNewSymptom = new Symptom(currentDate, currentSymptom);
        Log.d("kaylyn", "logSymptom:" + addNewSymptom);
        mRepository.insert(addNewSymptom);
    }

    public LiveData<List<Symptom>> getAllSymptoms() { return mAllSymptoms; }

    public void insert(Symptom symptom) { mRepository.insert(symptom); }
}

