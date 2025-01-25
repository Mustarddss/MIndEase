package com.example.updatedidverification;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Choose_ID extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_id);

        // Set listeners for ID selection buttons
        findViewById(R.id.governmentIdButton).setOnClickListener(this::onOptionSelected);
        findViewById(R.id.studentIdButton).setOnClickListener(this::onOptionSelected);
        findViewById(R.id.passportButton).setOnClickListener(this::onOptionSelected);
        findViewById(R.id.driversLicenseButton).setOnClickListener(this::onOptionSelected);

        // Set back arrow listener
        findViewById(R.id.backArrow).setOnClickListener(v -> {
            onBackPressed(); // Ensures correct back navigation
        });
    }

    public void onOptionSelected(View view) {
        int id = view.getId();

        if (id == R.id.governmentIdButton) {
            interact("Government ID selected.");
        } else if (id == R.id.studentIdButton) {
            interact("Student/School ID selected.");
        } else if (id == R.id.passportButton) {
            interact("Passport selected.");
        } else if (id == R.id.driversLicenseButton) {
            interact("Driver's License selected.");
        }
    }

    private void interact(String selectedOption) {
        Toast.makeText(this, selectedOption + " selected.", Toast.LENGTH_SHORT).show();

        // Pass the selected option to the next activity
        Intent intent = new Intent(this, ID_Verification.class);
        intent.putExtra("SELECTED_ID", selectedOption);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // Ensures that the back navigation works properly
        super.onBackPressed();
    }
}
