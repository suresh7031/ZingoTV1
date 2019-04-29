package com.example.zingotv.Models;

import androidx.room.Embedded;

public class InfoMenu {
private int status;
@Embedded
private DescriptionMenu description;
private boolean isfullbanner;
@Embedded
private BannerMenu banner;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DescriptionMenu getDescription() {
        return description;
    }

    public void setDescription(DescriptionMenu description) {
        this.description = description;
    }

    public boolean isIsfullbanner() {
        return isfullbanner;
    }

    public void setIsfullbanner(boolean isfullbanner) {
        this.isfullbanner = isfullbanner;
    }

    public BannerMenu getBanner() {
        return banner;
    }

    public void setBanner(BannerMenu banner) {
        this.banner = banner;
    }
}
