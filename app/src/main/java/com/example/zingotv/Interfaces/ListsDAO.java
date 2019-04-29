package com.example.zingotv.Interfaces;

import com.example.zingotv.Models.Lists;
import com.example.zingotv.Models.ListsEvents;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
@Dao
public interface ListsDAO {
    @Query("SELECT * FROM Lists_table")
    List<Lists> LISTS();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLists(List<Lists> lists);

    //@Query("drop table if exists Lists_table")

    @Query("DELETE FROM Lists_table ")
    void deleteAllList();


}
