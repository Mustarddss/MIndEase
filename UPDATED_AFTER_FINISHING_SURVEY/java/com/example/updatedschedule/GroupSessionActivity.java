package com.example.updatedschedule;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class GroupSessionActivity extends AppCompatActivity {
    private ImageView navChat, navCalendar, navGroup, navMore;
    private RecyclerView recyclerView;
    private GroupSessionAdapter adapter;
    private List<String> sessionTopics = Arrays.asList(
            "Talk about Anxiety",
            "Talk about Depression",
            "Talk about Academic Issue",
            "Talk about Work Issue",
            "Talk about Grief or Loss"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_sessions);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new GroupSessionAdapter(sessionTopics, new GroupSessionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String topic) {
                Intent intent = new Intent(GroupSessionActivity.this, ChatActivity.class);
                intent.putExtra("TOPIC", topic);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);

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
