package com.example.roomdatabase;

import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    private final String TAG = RoomActivity.class.getSimpleName();

    private RoomAdapter roomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.messages);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RoomActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        MessageDao messageDao = (MessageDao) AppDatabase.getInstance(getApplicationContext()).message();
        messageDao.getAllMessage().observe(this, new Observer<List<Message>>() {
            @Override
            public void onChanged(List<Message> message) {
                roomAdapter = new RoomAdapter(RoomActivity.this, message);
                recyclerView.setAdapter(roomAdapter);
            }
        });

        ImageView addMessageBtn = (ImageView) findViewById(R.id.add);
        addMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageDialog dialog = new MessageDialog(RoomActivity.this);
                dialog.addNewMessage(R.layout.dialog_layout);
            }
        });
    }
}