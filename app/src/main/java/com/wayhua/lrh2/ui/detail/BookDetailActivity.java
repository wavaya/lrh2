package com.wayhua.lrh2.ui.detail;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wayhua.lrh2.R;
import com.wayhua.lrh2.databinding.ActivityBookDetailBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class BookDetailActivity extends AppCompatActivity
        implements LifecycleRegistryOwner {
    private static final String ISBN = "isbn";
    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Inject
    BookDetailViewModel viewModel;
    ActivityBookDetailBinding binding;

    public static void start(Context context, String isbn) {
        Intent intent = new Intent(context, BookDetailActivity.class);
        intent.putExtra(ISBN, isbn);
         context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_book_detail);
        String isbn = getIntent().getStringExtra(ISBN);
        viewModel.getBookInfo(isbn)
                .observe(this, movieEntity -> binding.setBookinfox(movieEntity.data));
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }
}
