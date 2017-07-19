package com.wayhua.lrh2.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wayhua.lrh2.data.remote.models.BookInfo;
import com.wayhua.lrh2.databinding.BookInfoItemBinding;


/**
 * Created by 黄卫华(wayhua@126.com) on 2017/7/17.
 */

public class BookViewHolder extends RecyclerView.ViewHolder {

    BookInfoItemBinding binding;

    public BookViewHolder(BookInfoItemBinding itemMovieListBinding, final BookInfoListCallback callback) {
        super(itemMovieListBinding.getRoot());
        this.binding = itemMovieListBinding;
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 callback.onBookInfoClicked(binding.getBookinfox(), binding.image);
            }
        });

    }

    public static BookViewHolder create(LayoutInflater inflater,
                                        ViewGroup viewGroup,
                                        BookInfoListCallback callback) {
        BookInfoItemBinding itemMovieListBinding = BookInfoItemBinding.inflate(inflater, viewGroup, false);
        return new BookViewHolder(itemMovieListBinding, callback);

    }

    public void onBind(BookInfo bookInfo) {
        binding.setBookinfox(bookInfo);
        binding.executePendingBindings();
    }
}
