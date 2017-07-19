package com.wayhua.lrh2.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.wayhua.lrh2.data.remote.models.BookInfo;


import java.util.List;

/**
 * Created by danny on 2017-07-16.
 */
@Dao
public interface BookInfoDao {
    @Query("SELECT * FROM " + BookInfo.TABLE_NAME)
    LiveData<List<BookInfo>> loadBookInfos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveBookInfos(List<BookInfo> bookInfos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveBookInfo( BookInfo  bookInfo );

    @Query("SELECT * FROM " + BookInfo.TABLE_NAME+" WHERE id=:id")
    LiveData<BookInfo> getBookInfo(int id);
    @Query("SELECT * FROM " + BookInfo.TABLE_NAME+" WHERE isbn13=:isbn")
    LiveData<BookInfo> getBookInfo(String isbn);

}
