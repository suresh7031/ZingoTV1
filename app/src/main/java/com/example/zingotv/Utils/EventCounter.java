package com.example.zingotv.Utils;

public class EventCounter {
    private int adapterposition;
    private int position;

    public EventCounter(int position) {
        this.adapterposition = adapterposition;
        this.position = position;
    }

    public int getCurrentPosition(){
        return this.position;
    }
    public void setCurrentPosition(int position){
        this.position=position;
    }
}
