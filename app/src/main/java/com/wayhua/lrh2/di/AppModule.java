package com.wayhua.lrh2.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.wayhua.lrh2.data.local.dao.BookInfoDao;
import com.wayhua.lrh2.data.local.db.BookInfoDatabase;
import com.wayhua.lrh2.data.remote.APIConstants;
import com.wayhua.lrh2.data.remote.IService;
import com.wayhua.lrh2.data.remote.logger.Logger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 黄卫华(wayhua@126.com) on 2017/7/18.
 */
@Module
public class AppModule {
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(APIConstants.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.readTimeout(APIConstants.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
           addLogger(okHttpClient);
        return okHttpClient.build();
    }

    private void addLogger(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new Logger());
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
// add your other interceptors …

// add logging as last interceptor
        builder.addInterceptor(logging);  // <-- this is the important line!


        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();


                // Customize the request
                Request request = original.newBuilder()
                        .header("Accept", "application/json")

                        .build();

                Response response = chain.proceed(request);

                // Customize or return the response
                return response;
            }
        });

    }

    @Provides
    @Singleton
    IService provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConstants.fromDouban)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(IService.class);
    }

    @Provides
    @Singleton
    BookInfoDatabase provideBookInfoDatabase(Application application) {
        return Room.databaseBuilder(application, BookInfoDatabase.class, "aa.db").build();
    }

    @Provides
    @Singleton
    BookInfoDao provideBookInfoDao(BookInfoDatabase movieDatabase) {
        return movieDatabase.bookInfoDao();
    }

}
