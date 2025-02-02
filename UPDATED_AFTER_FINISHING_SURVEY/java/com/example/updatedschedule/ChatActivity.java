package com.example.updatedschedule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    private ImageView navChat, navCalendar, navGroup, navMore;
    TextView title;
    RecyclerView recyclerView;
    EditText editText;
    Button sendButton;
    ChatAdapter chatAdapter;
    ArrayList<String> chatMessages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        title = findViewById(R.id.chatTitle);
        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.messageInput);
        sendButton = findViewById(R.id.sendButton);

        String topic = getIntent().getStringExtra("TOPIC");
        title.setText(topic);

        chatAdapter = new ChatAdapter(chatMessages);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString().trim();
                if (!message.isEmpty()) {
                    chatMessages.add("Me: " + message);
                    chatAdapter.notifyDataSetChanged();
                    editText.setText("");
                }
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
