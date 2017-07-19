package com.wayhua.lrh2.data.remote.logger;


import android.util.Log;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by 黄卫华(wayhua@126.com) on 2017/3/20.
 */

public class Logger implements HttpLoggingInterceptor.Logger {
    @Override
    public void log(String message) {
        Log.e("net", message);
    }
}
