package com.wayhua.lrh2.data.local.db;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by 黄卫华(wayhua@126.com) on 2017-07-16.
 */

public class ListTypeConverter {
    private static Gson gson = new Gson();

    @TypeConverter
    public static List<String> toList(String str) {
        return str == null ? null : (List<String>) gson.fromJson(str, new TypeToken<List<String>>() {
        }.getType());
    }

    @TypeConverter
    public static String toStr(List<String> list) {
        return list == null ? null : gson.toJson(list);
    }
}
