package com.example.roomdatabase;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;


@Dao
public interface MessageDao {

    @Query("Select * from Message")
    public LiveData<List<Message>> getAllMessage();

    @Delete
    public void deleteMessage(Message message);

    @Insert(onConflict = REPLACE)
    public void insertNewMessage(Message message);
}
