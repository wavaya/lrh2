package com.wayhua.lrh2.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;


import com.wayhua.lrh2.data.local.dao.BookInfoDao;
import com.wayhua.lrh2.data.remote.IService;
import com.wayhua.lrh2.data.remote.NetworkBoundResource;
import com.wayhua.lrh2.data.remote.models.BookInfo;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by 黄卫华(wayhua@126.com) on 2017/7/17.
 */

public class BookInfoRepository {

    private final BookInfoDao bookInfoDao;
    private final IService iService;

    @Inject
    public BookInfoRepository(BookInfoDao movieDao, IService movieDBService) {
        this.bookInfoDao = movieDao;
        this.iService = movieDBService;
    }

    public LiveData<Resource<BookInfo>> getBookInfo(String isbn) {
        return new NetworkBoundResource<BookInfo,BookInfo>(){

            @Override
            protected void saveCallResult(@NonNull BookInfo item) {
                bookInfoDao.saveBookInfo(item);
            }

            @NonNull
            @Override
            protected LiveData<BookInfo> loadFromDb() {
                return bookInfoDao.getBookInfo(isbn);
            }

            @NonNull
            @Override
            protected Call<BookInfo> createCall() {

                return iService.getBookInfoByIsbn(isbn);
            }
        }.getAsLiveData();

    }

    public LiveData<Resource<List<BookInfo>>> loadBookInfos() {
        //  return bookInfoDao.loadBookInfos();

        MediatorLiveData<Resource<List<BookInfo>>> result = new MediatorLiveData<>();
        result.setValue(Resource.loading(null));

        LiveData<List<BookInfo>> bookinfos = bookInfoDao.loadBookInfos();

        result.addSource(bookinfos, data -> {
            result.removeSource(bookinfos);

            result.addSource(bookinfos, newData -> result.setValue(Resource.success(newData)));


        });

        return result;
    }
}
