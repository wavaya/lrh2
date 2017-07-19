package com.wayhua.lrh2.ui.main;

import android.view.View;

import com.wayhua.lrh2.data.remote.models.BookInfo;


/**
 * Created by 黄卫华(wayhua@126.com) on 2017/7/17.
 */

public interface BookInfoListCallback {
    void onBookInfoClicked(BookInfo bookInfo, View sharedView);

}
