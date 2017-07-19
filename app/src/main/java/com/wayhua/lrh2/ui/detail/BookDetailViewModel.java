package com.wayhua.lrh2.ui.detail;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.wayhua.lrh2.data.BookInfoRepository;
import com.wayhua.lrh2.data.Resource;
import com.wayhua.lrh2.data.remote.models.BookInfo;

import javax.inject.Inject;

/**
 * Created by 黄卫华(wayhua@126.com) on 2017/7/18.
 */

public class BookDetailViewModel extends ViewModel {

    private final LiveData<Resource<BookInfo>> movieDetail = new MutableLiveData<>();
    private final BookInfoRepository movieRepository;

    @Inject
    public BookDetailViewModel(BookInfoRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public LiveData<Resource<BookInfo>> getBookInfo(String isbn){
        return movieRepository.getBookInfo(isbn);
    }

}
