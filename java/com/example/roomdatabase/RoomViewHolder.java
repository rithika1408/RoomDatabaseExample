package com.example.roomdatabase;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RoomViewHolder extends RecyclerView.ViewHolder{
    public TextView content,contentDate;
    public ImageView contentDelete;
    public RoomViewHolder(View itemView) {
        super(itemView);
        content = (TextView)itemView.findViewById(R.id.content);
        contentDate = (TextView)itemView.findViewById(R.id.content_date);
        contentDelete = (ImageView)itemView.findViewById(R.id.content_delete);
    }
}
