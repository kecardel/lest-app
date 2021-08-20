package com.example.lest.data;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lest.R;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.List;

public class SymptomViewModel extends AndroidViewModel {
    private DbRepository mRepository;

    private final LiveData<List<Symptom>> mAllSymptoms;
    private MutableLiveData<String> currentDateString = new MutableLiveData<>("");
    private String currentSymptom = "";

    public LocalDate getLocalDate() {
        return LocalDate.now();
    }
    private LocalDate currentDate = getLocalDate();
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

        currentDate = getLocalDate( updatedCalendar );
        Log.d("kaylyn", "currentDate:" + currentDate);
        currentDateString.setValue(dateFormat.format(updatedCalendar.getTime()));
    }

    private static java.time.LocalDate getLocalDate(Calendar calendar){

        return  LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId()).toLocalDate();
    }
    public void onSymptomTextChanged(String symptom) {
        currentSymptom = symptom;
    }

    public void logSymptom() {
        // interact with DbRepository here
        Symptom addNewSymptom = new Symptom(currentDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)), currentSymptom);
        Log.d("kaylyn", "logSymptom:" + addNewSymptom);
        mRepository.insert(addNewSymptom);
    }

    public LiveData<List<Symptom>> getAllSymptoms() { return mAllSymptoms; }

    public void insert(Symptom symptom) { mRepository.insert(symptom); }

}

