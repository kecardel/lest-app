package com.example.lest;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lest.data.Symptom;
import com.example.lest.data.SymptomDao;
import com.example.lest.data.SymptomViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class SymptomFragment extends Fragment {

    private ImageButton changeDate;
    private TextView today;
    private Calendar calendar = Calendar.getInstance();
    private FloatingActionButton submitSymptom;
    private EditText newSymptom;
    private SymptomViewModel symptomViewModel;


    public SymptomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        symptomViewModel = new ViewModelProvider(this).get(SymptomViewModel.class); // basically a complicated way to do "new SymptomViewModel();"
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_symptom, container, false);
        today = viewGroup.findViewById(R.id.today);
        newSymptom = viewGroup.findViewById(R.id.symptomEntry);
        newSymptom.addTextChangedListener(new SymptomTextWatcher());
        changeDate = viewGroup.findViewById(R.id.changeDate);
        changeDate.setOnClickListener(new SymptomFragment.ChangeDateClickListener());

        submitSymptom = viewGroup.findViewById(R.id.submitSymptom);
        submitSymptom.setOnClickListener(new SymptomFragment.SubmitSymptomClickListener());

        return viewGroup;
    }

    @Override
    public void onResume() {
        super.onResume();
        symptomViewModel.getCurrentDateLiveData().observe(this, dateString -> {
            today.setText(dateString);
        });
    }

    private class ChangeDateClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Log.d("ada", "onClick: changeDate");
            // 1. create a DatePickerDialog
            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                    new SymptomFragment.CalendarListener(),
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            // 1a. when creating DatePickerDialog, pass it new DatePickerDialog.OnDateSetListener()
            // 2. call show() on the DatePickerDialog instance
            datePickerDialog.show();
        }
    }

    private class CalendarListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            symptomViewModel.onDatePickerSubmitted(year, month, day);
        }
    }

    private class SubmitSymptomClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Log.d("ada", "onClick: submitSymptom");
            symptomViewModel.logSymptom();
            newSymptom.setText(null);

        }
    }

    private class SymptomTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Do nothing.
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Do nothing.
        }

        @Override
        public void afterTextChanged(Editable editable) {
            symptomViewModel.onSymptomTextChanged(editable.toString());
        }
    }
}
