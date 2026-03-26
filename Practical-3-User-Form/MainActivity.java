package com.example.practical3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword, etEmail, etPhone, etCountry, etState, etBirthDate, etBirthTime;
    RadioGroup rgGender;
    CheckBox cbSports, cbMusic, cbReading;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etCountry = findViewById(R.id.etCountry);
        etState = findViewById(R.id.etState);
        etBirthDate = findViewById(R.id.etBirthDate);
        etBirthTime = findViewById(R.id.etBirthTime);
        rgGender = findViewById(R.id.rgGender);
        cbSports = findViewById(R.id.cbSports);
        cbMusic = findViewById(R.id.cbMusic);
        cbReading = findViewById(R.id.cbReading);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {

            int selectedId = rgGender.getCheckedRadioButtonId();
            RadioButton rb = findViewById(selectedId);
            String gender = rb != null ? rb.getText().toString() : "Not Selected";

            String interests = "";
            if (cbSports.isChecked()) interests += "Sports ";
            if (cbMusic.isChecked()) interests += "Music ";
            if (cbReading.isChecked()) interests += "Reading ";

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);

            intent.putExtra("data",
                    "Username: " + etUsername.getText().toString() +
                            "\nPassword: " + etPassword.getText().toString() +
                            "\nEmail: " + etEmail.getText().toString() +
                            "\nPhone: " + etPhone.getText().toString() +
                            "\nCountry: " + etCountry.getText().toString() +
                            "\nState: " + etState.getText().toString() +
                            "\nGender: " + gender +
                            "\nInterests: " + interests +
                            "\nBirth Date: " + etBirthDate.getText().toString() +
                            "\nBirth Time: " + etBirthTime.getText().toString()
            );

            startActivity(intent);
        });
    }
}