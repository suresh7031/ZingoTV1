package com.example.zingotv.Models;

import androidx.room.Embedded;

public class MenuItems {

    private String id;
    private String cat_hex;
    private String name;
    private String type;
    @Embedded
    private ImageMenu img;
    private String icon;
    private String url;
    @Embedded
    private InfoMenu info;
    private String subitems;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat_hex() {
        return cat_hex;
    }

    public void setCat_hex(String cat_hex) {
        this.cat_hex = cat_hex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubitems() {
        return subitems;
    }

    public void setSubitems(String subitems) {
        this.subitems = subitems;
    }
}
