package com.example.zingotv.Models;

import com.example.zingotv.Models.Converters.DataTypeConverter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.room.Embedded;

import androidx.room.TypeConverters;

public class Items {

    @SerializedName("id")
    private int items_id;
    private int eventStartTime;
    private int eventEndTime;

    @Embedded(prefix = "pager_")
    private Pager pager;

    @TypeConverters(DataTypeConverter.class)
    private List<Lists> lists = null;


    public int getItems_id() {
        return items_id;
    }

    public void setItems_id(int items_id) {
        this.items_id = items_id;
    }

    public int getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(int eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public int getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(int eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public List<Lists> getLists() {
        return lists;
    }

    public void setLists(List<Lists> lists) {
        this.lists = lists;
    }
}
