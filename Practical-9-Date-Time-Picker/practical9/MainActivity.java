package com.example.practical9;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker timePicker;
    Button showButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        showButton = findViewById(R.id.showButton);
        resultTextView = findViewById(R.id.resultTextView);

        // Button click listener
        showButton.setOnClickListener(v -> {
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1; // Month is 0-based
            int year = datePicker.getYear();

            int hour = timePicker.getHour();    // API 23+
            int minute = timePicker.getMinute();

            String dateTime = "Selected Date: " + day + "/" + month + "/" + year +
                    "\nSelected Time: " + String.format("%02d:%02d", hour, minute);

            resultTextView.setText(dateTime);
        });
    }
}