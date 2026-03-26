package com.example.practical11;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    CheckBox remember;
    Button login;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        remember = findViewById(R.id.remember);
        login = findViewById(R.id.login);

        sharedPreferences = getSharedPreferences("LoginData", MODE_PRIVATE);

        // Load saved data
        String savedEmail = sharedPreferences.getString("email", "");
        String savedPass = sharedPreferences.getString("password", "");

        email.setText(savedEmail);
        password.setText(savedPass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e = email.getText().toString();
                String p = password.getText().toString();

                if (remember.isChecked()) {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("email", e);
                    editor.putString("password", p);
                    editor.apply();
                }

                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                intent.putExtra("email", e);
                startActivity(intent);
            }
        });
    }
}