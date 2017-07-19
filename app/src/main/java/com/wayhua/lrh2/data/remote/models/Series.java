package com.wayhua.lrh2.data.remote.models;


import android.arch.persistence.room.ColumnInfo;

import java.io.Serializable;

/**
 * Created by 黄卫华(wayhua@126.com) on 2016/4/28.
 */
public class Series implements Serializable {

    @ColumnInfo(name = "series_id")
    private String id;
    @ColumnInfo(name = "series_title")
    private String title;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

}
