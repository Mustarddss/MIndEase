package com.example.idverification;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Biometr_FaceVerification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biometrfaceverification);

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
    }
}
