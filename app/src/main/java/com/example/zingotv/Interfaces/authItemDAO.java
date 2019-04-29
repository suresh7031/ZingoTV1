package com.example.zingotv.Interfaces;


import com.example.zingotv.Models.JSONData;
import com.example.zingotv.Models.Lists;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.DatabaseView;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface authItemDAO {

    @Insert
    Long insert(JSONData data);

    @Update
    int update(JSONData data);

    @Delete
    void delete(JSONData data);

    //@Query("drop table if exists items_auth_table")
    @Query("DELETE FROM items_auth_table")
    void deleteAllData();


    @Query("SELECT * FROM items_auth_table")
    LiveData<List<JSONData>> getData();

    @Query("SELECT * FROM items_auth_table")
   JSONData getDataDb();




   /*//@SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT itemslists FROM items_auth_table")
    LiveData<List<Lists>> getLists();*/
}
