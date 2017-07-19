package com.wayhua.lrh2.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.wayhua.lrh2.data.local.dao.BookInfoDao;
import com.wayhua.lrh2.data.remote.models.BookInfo;


@Database(entities = {BookInfo.class}, version = 1, exportSchema = false)
@TypeConverters({ListTypeConverter.class,TagsTypeConverter.class})
public abstract class BookInfoDatabase extends RoomDatabase {

    public abstract BookInfoDao bookInfoDao();
}
