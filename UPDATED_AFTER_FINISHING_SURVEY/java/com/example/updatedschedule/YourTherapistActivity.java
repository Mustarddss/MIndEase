package com.example.updatedschedule;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class YourTherapistActivity extends AppCompatActivity {
    private ImageView Messages, Schedule, Community, More;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_therapist);

        setupBottomNavigation();
    }
    private void setupBottomNavigation() {
        Messages = findViewById(R.id.iconMessages);
        Schedule = findViewById(R.id.iconSchedule);
        Community = findViewById(R.id.iconCommunity);
        More = findViewById(R.id.iconMore);

        Messages.setOnClickListener(v -> startActivity(new Intent(this, PrivateMessageActivity.class)));
        Schedule.setOnClickListener(v -> startActivity(new Intent(this, ScheduleActivity.class)));
        Community.setOnClickListener(v -> startActivity(new Intent(this, GroupSessionActivity.class)));
        More.setOnClickListener(v -> startActivity(new Intent(this, MoreFeaturesActivity.class)));
    }
}


