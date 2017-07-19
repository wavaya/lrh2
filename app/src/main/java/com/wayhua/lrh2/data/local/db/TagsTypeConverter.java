package com.wayhua.lrh2.data.local.db;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.wayhua.lrh2.data.remote.models.Tags;

import java.util.List;

/**
 * Created by 黄卫华(wayhua@126.com) on 2017/7/18.
 */

public class TagsTypeConverter {
    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Tags> toList(String str) {
        return str == null ? null : (List<Tags>) gson.fromJson(str, new TypeToken<List<Tags>>() {
        }.getType());
    }

    @TypeConverter
    public static String toStr(List<Tags> list) {
        return list == null ? null : gson.toJson(list);
    }
}
