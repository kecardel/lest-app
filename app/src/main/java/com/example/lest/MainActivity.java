package com.example.lest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    // Define key for date intent's extra using a public constant
    public final static String EXTRA_DATE = "com.example.lest.DATE";

    // 1. Declare widget variables

    private ImageButton changeDate;
    private TextView today;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // bottom nav bar
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        // upon app open, first fragment shown is Log
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LogFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // By using switch we can easily get
            // the selected fragment
            // by using there id.
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.Plan:
                    selectedFragment = new PlanFragment();
                    break;
                case R.id.Log:
                    selectedFragment = new LogFragment();
                    break;
                case R.id.Symptom:
                    selectedFragment = new SymptomFragment();
                    break;
            }
            // It will help to replace the
            // one fragment to other.
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        }
    };

//
//    private class LogSymptomListener implements View.OnClickListener {
//
//        @Override
//        public void onClick(View view) {
//            Log.d("ada", "onClick: symptom home page");
//            Intent intent = new Intent(MainActivity.this, SymptomHomeActivity.class);
//            TextView selectedDate = (TextView) findViewById(R.id.today);
//            String date = selectedDate.getText().toString();
//            intent.putExtra(EXTRA_DATE, date);
//            startActivity(intent);
//        }
//    }
//
//    private class TreatmentPlanListener implements View.OnClickListener {
//
//        @Override
//        public void onClick(View view) {
//            Log.d("ada", "onClick: tp home page");
//            Intent intent = new Intent(MainActivity.this, TreatmentPlanHomeActivity.class);
//            TextView selectedDate = (TextView) findViewById(R.id.today);
//            String date = selectedDate.getText().toString();
//            intent.putExtra(EXTRA_DATE, date);
//            startActivity(intent);
//        }
//    }


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

