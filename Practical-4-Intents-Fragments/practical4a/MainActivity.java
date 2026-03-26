package com.example.practical4a;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class MainActivity extends AppCompatActivity {

    Button btnWebsite, btnLocation, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWebsite = findViewById(R.id.btnWebsite);
        btnLocation = findViewById(R.id.btnLocation);
        btnShare = findViewById(R.id.btnShare);

        // Open Website
        btnWebsite.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        // Open Location
        btnLocation.setOnClickListener(v -> {
            Uri location = Uri.parse("geo:21.1702,72.8311?q=Surat");
            Intent intent = new Intent(Intent.ACTION_VIEW, location);
            startActivity(intent);
        });

        // Share Text
        btnShare.setOnClickListener(v -> {
            ShareCompat.IntentBuilder.from(this)
                    .setType("text/plain")
                    .setText("Hello from Android App!")
                    .setChooserTitle("Share using")
                    .startChooser();
        });
    }
}