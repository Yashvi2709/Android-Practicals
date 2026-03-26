package com.example.practical10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNo1, edtNo2;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNo1 = findViewById(R.id.edtNo1);
        edtNo2 = findViewById(R.id.edtNo2);
        txtResult = findViewById(R.id.txtResult);
    }

    // Create option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    // Handle menu click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String num1Str = edtNo1.getText().toString();
        String num2Str = edtNo2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return true;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result;

        int id = item.getItemId();

        if (id == R.id.addition) {
            result = num1 + num2;
            txtResult.setText("Result: " + result);
            return true;

        } else if (id == R.id.subtraction) {
            result = num1 - num2;
            txtResult.setText("Result: " + result);
            return true;

        } else if (id == R.id.multiplication) {
            result = num1 * num2;
            txtResult.setText("Result: " + result);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}