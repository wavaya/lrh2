package com.wayhua.lrh2.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.wayhua.lrh2.data.remote.models.BookInfo;
import com.wayhua.lrh2.ui.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 黄卫华(wayhua@126.com) on 2017/7/17.
 */

public class BookInfoListAdapter extends BaseAdapter<BookViewHolder, BookInfo> {
    private final BookInfoListCallback callback;
    private List<BookInfo> bookInfos;

    public BookInfoListAdapter(BookInfoListCallback callback) {
        this.callback = callback;
        bookInfos = new ArrayList<>();

    }
    @Override
    public void setData(List<BookInfo> bookInfos) {
        this.bookInfos = bookInfos;
        notifyDataSetChanged();
    }


    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return BookViewHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup, callback);

    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        holder.onBind(bookInfos.get(position));
    }

    @Override
    public int getItemCount() {
        return bookInfos == null ? 0 : bookInfos.size();
    }
}
