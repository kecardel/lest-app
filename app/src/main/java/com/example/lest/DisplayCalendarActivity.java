package com.example.lest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;


public class DisplayCalendarActivity extends AppCompatActivity {

//    DatePickerDialog picker;
//    TextView selectedDate;

    private TextView selectDatePrompt;
    private CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_calendar);

//        selectedDate = (TextView) findViewById(R.id.today);
//
//        @Override
//        public void onClick(View v) {
//
//            final Calendar calendar = Calendar.getInstance();
//            int day = calendar.get(Calendar.DAY_OF_MONTH);
//            int month = calendar.get(Calendar.MONTH);
//            int year = calendar.get(Calendar.YEAR);
//            // Date picker dialog
//            picker = new DatePickerDialog(DisplayCalendarActivity.this,
//                    new DatePickerDialog.OnDateSetListener() {
//                        @Override
//                        public void OnDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
//                        {
//                            today.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
//                        }, year, month, day);
//                    picker.show();
//                        });
//                    };




        selectDatePrompt = (TextView) findViewById(R.id.selectDateText);
        calendar = (CalendarView) findViewById(R.id.selectDateCal);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(
                    @NonNull CalendarView view,
                    int year,
                    int month,
                    int dayOfMonth)
                {
                    String Date = dayOfMonth + "-" + (month + 1) + "-" + year;
                    selectDatePrompt.setText(Date);
                    }
            });
    }
}