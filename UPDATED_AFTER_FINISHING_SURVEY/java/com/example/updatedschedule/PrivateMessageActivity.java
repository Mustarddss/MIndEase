package com.example.updatedschedule;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PrivateMessageActivity extends AppCompatActivity {
    private TextView urgentLabel, therapistMessage;
    private EditText messageInput;
    private ImageView callButton, navChat, navCalendar, navGroup, navMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_message);

        // Find views
        urgentLabel = findViewById(R.id.urgent_label);
        therapistMessage = findViewById(R.id.therapist_message);
        messageInput = findViewById(R.id.message_input);
        callButton = findViewById(R.id.call_button);

        // Show urgent label if required
        boolean isUrgent = true;
       // urgentLabel.setVisibility(isUrgent ? View.VISIBLE : View.GONE);

        // Call button action
        callButton.setOnClickListener(v -> {
            String phoneNumber = "tel:+123456789"; // Example therapist number
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber));
            startActivity(intent);
        });

        // Bottom navigation setup
        setupBottomNavigation();
    }

    private void setupBottomNavigation() {
        navChat = findViewById(R.id.nav_chat);
        navCalendar = findViewById(R.id.nav_calendar);
        navGroup = findViewById(R.id.nav_group);
        navMore = findViewById(R.id.nav_more);

        navChat.setOnClickListener(v -> startActivity(new Intent(this, PrivateMessageActivity.class)));
        navCalendar.setOnClickListener(v -> startActivity(new Intent(this, ScheduleActivity.class)));
        navGroup.setOnClickListener(v -> startActivity(new Intent(this, GroupSessionActivity.class)));
        navMore.setOnClickListener(v -> startActivity(new Intent(this, MoreFeaturesActivity.class)));
    }
}

