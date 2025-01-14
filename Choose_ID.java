package com.example.idverification;
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
        findViewById(R.id.governmentIdButton).setOnClickListener(this::onOptionSelected);
        findViewById(R.id.studentIdButton).setOnClickListener(this::onOptionSelected);
        findViewById(R.id.passportButton).setOnClickListener(this::onOptionSelected);
        findViewById(R.id.driversLicenseButton).setOnClickListener(this::onOptionSelected);
        findViewById(R.id.backArrow).setOnClickListener(v ->finish());
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

        // Pass the selected option to next activity
        Intent intent = new Intent(this, Biometr_ID.class);
        intent.putExtra("selected_option", selectedOption);
        startActivity(intent);
    }
}
