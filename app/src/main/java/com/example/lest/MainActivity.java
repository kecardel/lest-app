package com.example.lest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    // Define key for date intent's extra using a public constant
    public final static String EXTRA_DATE = "com.example.lest.DATE";

    // 1. Declare widget variables

    private Button symptom;
    private Button meds;
    private Button summary;
    private ImageButton changeDate;

    private TextView today;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dateTimeDisplay = (TextView) findViewById(R.id.today);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy");
        date = dateFormat.format(calendar.getTime());

        dateTimeDisplay.setText(date);

        // 2. Initialize widget variables by connecting them to their IDs.
        symptom = (Button) findViewById(R.id.logSymptoms);
        meds = (Button) findViewById(R.id.medList);
        summary = (Button) findViewById(R.id.summary);
        changeDate = (ImageButton) findViewById(R.id.changeDate);
    }
//
//     Called when the user clicks the calendar button
//    public void changeDate(View view) {
//        // Called when the user clicks the calendar image button
//        // Create an intent with user-selected date (or today's date) to displayCalendarActivity
//        Intent intent = new Intent(this, DisplayCalendarActivity.class);
//        TextView selectedDate = (TextView) findViewById(R.id.today);
//        String date = selectedDate.getText().toString();
//        intent.putExtra(EXTRA_DATE, date);
//        startActivity(intent);
//    }


//        3. Extract widget into a usable java form
}

