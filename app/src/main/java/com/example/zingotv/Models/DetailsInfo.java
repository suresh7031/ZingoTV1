package com.example.zingotv.Models;

import androidx.room.Embedded;

public class DetailsInfo {
    private String img;
    private String text;
    @Embedded
    private DetailsButton button;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public DetailsButton getButton() {
        return button;
    }

    public void setButton(DetailsButton button) {
        this.button = button;
    }
}
