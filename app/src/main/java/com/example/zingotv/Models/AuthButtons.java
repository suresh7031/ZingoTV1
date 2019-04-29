package com.example.zingotv.Models;

import com.google.gson.annotations.SerializedName;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.TypeConverters;


public class AuthButtons {
    @SerializedName("id")
    private int auth_id;
    private String showin;
    private String name;
    private String type;
    private String useIcon;
    @Embedded
    private IconAuthBtn icon;
    private String show;
    private String url;



    public int getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(int auth_id) {
        this.auth_id = auth_id;
    }

    public String getShowin() {
        return showin;
    }

    public void setShowin(String showin) {
        this.showin = showin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUseIcon() {
        return useIcon;
    }

    public void setUseIcon(String useIcon) {
        this.useIcon = useIcon;
    }

    public IconAuthBtn getIcon() {
        return icon;
    }

    public void setIcon(IconAuthBtn icon) {
        this.icon = icon;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
