package com.example.roomdatabase;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;


import org.joda.time.DateTime;
import java.util.Date;
import java.util.List;
public class RoomAdapter extends RecyclerView.Adapter<RoomViewHolder> {
    private List<Message> messageList;
    private Context context;
    AppDatabase database;
    public RoomAdapter(Context context, List<Message> messageList) {
        this.messageList = messageList;
        this.context = context;
    }
    @Override
    public RoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_layout, parent, false);
        return new RoomViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final RoomViewHolder holder, final int position) {
        final Message message = messageList.get(position);
        String currentDate = getCurrentDateTime();
        holder.content.setText(message.getContent());
        holder.contentDate.setText(currentDate);
        holder.contentDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MessageDao messageDao = (MessageDao) AppDatabase.getInstance(context).message();
                messageDao.deleteMessage(message);


            }
        });
    }
    @Override
    public int getItemCount() {
        return messageList.size();
    }
    private String getCurrentDateTime(){
        Date currentDate = new Date();
        DateTime dt = new DateTime(currentDate);
        return dt.toString();
    }
}
