package com.example.practical14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button takeOrder, viewOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        takeOrder = findViewById(R.id.takeOrder);
        viewOrder = findViewById(R.id.viewOrder);

        takeOrder.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TakeOrderActivity.class));
        });

        viewOrder.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ViewOrderActivity.class));
        });
    }
}