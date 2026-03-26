package com.example.practical12;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = editText.getText().toString();

                try {

                    FileOutputStream fos = openFileOutput("myfile.txt", MODE_PRIVATE);
                    fos.write(text.getBytes());
                    fos.close();

                    Toast.makeText(MainActivity.this,
                            "File Saved Successfully",
                            Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,
                            "Error Saving File",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}