package com.example.updatedschedule;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class YourTherapistActivity extends AppCompatActivity {
    private ImageView navChat, navCalendar, navGroup, navMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_therapist);

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
