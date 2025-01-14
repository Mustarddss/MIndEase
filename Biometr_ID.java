package com.example.idverification;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Biometr_ID extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biometrid);

        // Retrieve the selected option from the Intent
        String selectedOption = getIntent().getStringExtra("selected_option");

        // Find the title TextView and set the selected option
        TextView titleTextView = findViewById(R.id.titleTextView);
        if (selectedOption != null) {
            titleTextView.setText(selectedOption);
        }
        findViewById(R.id.backArrow).setOnClickListener(v -> finish());
        findViewById(R.id.captureButton).setOnClickListener(v -> {
            Toast.makeText(this, "Capture Button Clicked!", Toast.LENGTH_SHORT).show();
            // TODO: Add functionality to capture the face using the camera
        });

        // Next button click
        findViewById(R.id.nextButton).setOnClickListener(v -> {
            // Pass the selected option to the next activity
            Intent intent = new Intent(Biometr_ID.this, Biometr_FaceVerification.class);
            intent.putExtra("selected_option", selectedOption);
            startActivity(intent);
        });
    }
}
