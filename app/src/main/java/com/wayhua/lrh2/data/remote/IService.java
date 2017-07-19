package com.wayhua.lrh2.data.remote;


import com.wayhua.lrh2.data.remote.models.BookInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by danny on 2017-07-16.
 */

public interface IService {
    @GET("/v2/book/isbn/{isbn}")
    Call<BookInfo> getBookInfoByIsbn(@Path("isbn") String isbn);

}
