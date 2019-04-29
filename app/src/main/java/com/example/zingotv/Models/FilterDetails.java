package com.example.zingotv.Models;

import androidx.room.Embedded;

public class FilterDetails {
    private String name;
    private boolean selected;
    @Embedded
    private FDetailsValues values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public FDetailsValues getValues() {
        return values;
    }

    public void setValues(FDetailsValues values) {
        this.values = values;
    }
}
