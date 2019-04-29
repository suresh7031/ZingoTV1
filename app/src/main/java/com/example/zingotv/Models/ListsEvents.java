package com.example.zingotv.Models;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "events_table")
public class ListsEvents {
    @PrimaryKey(autoGenerate = true)
    private int eid;
    private int PchNo;
    private int events_id;
    private String name;
    private String description;
    private String image;
    private int recordingFeature;
    private int isRecordingEnabled;
    private int start;
    private int end;
    private String duration;
    private String current;
    @Embedded
    private ListsEventImg img;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getPchNo() {
        return PchNo;
    }

    public void setPchNo(int pchNo) {
        PchNo = pchNo;
    }

    public int getEvents_id() {
        return events_id;
    }

    public void setEvents_id(int events_id) {
        this.events_id = events_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRecordingFeature() {
        return recordingFeature;
    }

    public void setRecordingFeature(int recordingFeature) {
        this.recordingFeature = recordingFeature;
    }

    public int getIsRecordingEnabled() {
        return isRecordingEnabled;
    }

    public void setIsRecordingEnabled(int isRecordingEnabled) {
        this.isRecordingEnabled = isRecordingEnabled;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public ListsEventImg getImg() {
        return img;
    }

    public void setImg(ListsEventImg img) {
        this.img = img;
    }
}
