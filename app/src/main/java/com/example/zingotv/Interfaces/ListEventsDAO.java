package com.example.zingotv.Interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.zingotv.Models.ListsEvents;

import java.util.List;

@Dao
public interface ListEventsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertevents(List<ListsEvents> listsEvents);

    @Query("select * from events_table")
    List<ListsEvents> getEvents();
}
