package com.example.practical8;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    // Mobile Names
    String[] mobileNames = {"Samsung", "iPhone", "OnePlus", "Pixel", "Xiaomi"};

    // Corresponding Images in drawable
    int[] mobileImages = {
            R.drawable.samsung,
            R.drawable.iphone,
            R.drawable.oneplus,
            R.drawable.pixel,
            R.drawable.xiaomi
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        MobileAdapter adapter = new MobileAdapter(this, mobileNames, mobileImages);
        gridView.setAdapter(adapter);
    }
}