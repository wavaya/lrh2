package com.wayhua.lrh2.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;


import com.wayhua.lrh2.data.BookInfoRepository;
import com.wayhua.lrh2.data.Resource;
import com.wayhua.lrh2.data.remote.models.BookInfo;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by 黄卫华(wayhua@126.com) on 2017/7/17.
 */

public class MainListViewModel extends ViewModel {
    private final LiveData<Resource<List<BookInfo>>> popularMovies;
    private final BookInfoRepository bookInfoRepository;

    @Inject
    public MainListViewModel(BookInfoRepository bookInfoRepository) {
        popularMovies = bookInfoRepository.loadBookInfos();
        this.bookInfoRepository = bookInfoRepository;
    }

    LiveData<Resource<List<BookInfo>>> getBookInfos() {
        return popularMovies;
    }


}
