package com.example.zingotv.Models;

import com.example.zingotv.Models.Converters.DataTypeConverterListsEvents;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import androidx.room.util.TableInfo;

import static androidx.room.ForeignKey.CASCADE;
import static com.google.gson.internal.$Gson$Types.arrayOf;

@Entity(tableName = "Lists_table")
//foreignKeys = {@ForeignKey(entity=JSONData.class,parentColumns = "id",childColumns ="id" ,onDelete = ForeignKey.CASCADE,
  //      onUpdate = ForeignKey.CASCADE)}
public class Lists {
    @PrimaryKey
    @NonNull
    @SerializedName("id")
    private String lists_id;
    private String title;
    @Embedded
    private ListsImage img;
    private String type;
    private String contentType;
    private String streamFormat;
    private int chNo;
    private String Live;
    private String category;
    private String language;
    private String genre;
    private String showVideoLogo;
    private String isFavourite;
    private String url;
    private String synopsis;
    private String genres;
    @TypeConverters(DataTypeConverterListsEvents.class)
    private List<ListsEvents> events;
    private boolean autoPlay;
    @NonNull
    private int userId;


    public String getLists_id() {
        return lists_id;
    }

    public void setLists_id(String lists_id) {
        this.lists_id = lists_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ListsImage getImg() {
        return img;
    }

    public void setImg(ListsImage img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getStreamFormat() {
        return streamFormat;
    }

    public void setStreamFormat(String streamFormat) {
        this.streamFormat = streamFormat;
    }

    public int getChNo() {
        return chNo;
    }

    public void setChNo(int chNo) {
        this.chNo = chNo;
    }

    public String getLive() {
        return Live;
    }

    public void setLive(String live) {
        Live = live;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getShowVideoLogo() {
        return showVideoLogo;
    }

    public void setShowVideoLogo(String showVideoLogo) {
        this.showVideoLogo = showVideoLogo;
    }

    public String getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(String isFavourite) {
        this.isFavourite = isFavourite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public List<ListsEvents> getEvents() {
        return events;
    }

    public void setEvents(List<ListsEvents> events) {
        this.events = events;
    }

    public boolean isAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
