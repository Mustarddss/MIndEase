package com.example.updatedschedule;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GroupSessionNextActivity extends AppCompatActivity {
    private TextView sessionTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_next_activity);

        sessionTitle = findViewById(R.id.sessionTitle);

        // Get the title from the intent
        String title = getIntent().getStringExtra("SESSION_TITLE");
        if (title != null) {
            sessionTitle.setText(title);
        }

        setupBottomNavigation();
    }

    private void setupBottomNavigation() {
        findViewById(R.id.nav_chat).setOnClickListener(v -> startActivity(new Intent(this, PrivateMessageActivity.class)));
        findViewById(R.id.nav_calendar).setOnClickListener(v -> startActivity(new Intent(this, ScheduleActivity.class)));
        findViewById(R.id.nav_group).setOnClickListener(v -> startActivity(new Intent(this, GroupSessionActivity.class)));
        findViewById(R.id.nav_more).setOnClickListener(v -> startActivity(new Intent(this, MoreFeaturesActivity.class)));
    }
}
