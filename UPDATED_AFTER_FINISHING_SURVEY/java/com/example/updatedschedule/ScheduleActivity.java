package com.example.updatedschedule;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ScheduleActivity extends AppCompatActivity {
    private CalendarView calendarView;
    private Button submitSchedule;
    private ImageView navChat, navCalendar, navGroup, navMore;
    private String selectedDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        calendarView = findViewById(R.id.calendarView);
        submitSchedule = findViewById(R.id.submitSchedule);

        // Select a date
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) ->
                selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year
        );

        // Submit button click
        submitSchedule.setOnClickListener(v -> {
            if (selectedDate.isEmpty()) {
                Toast.makeText(this, "Please select a date", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Scheduled on " + selectedDate, Toast.LENGTH_LONG).show();
            }
        });

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
