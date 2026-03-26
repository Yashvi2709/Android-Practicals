package com.example.practical7;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout rootLayout;
    private ListView colorListView;

    // Array of color names
    private String[] colors = {"Red", "Green", "Blue", "Yellow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.root_layout);
        colorListView = findViewById(R.id.colorListView);

        // Create an ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, colors);
        colorListView.setAdapter(adapter);

        // Set click listener
        colorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedColor = colors[position];
                changeBackgroundColor(selectedColor);
            }
        });
    }

    private void changeBackgroundColor(String colorName) {
        switch (colorName.toLowerCase()) {
            case "red":
                rootLayout.setBackgroundColor(Color.RED);
                break;
            case "green":
                rootLayout.setBackgroundColor(Color.GREEN);
                break;
            case "blue":
                rootLayout.setBackgroundColor(Color.BLUE);
                break;
            case "yellow":
                rootLayout.setBackgroundColor(Color.YELLOW);
                break;
        }
    }
}