package com.wayhua.lrh2.ui.main;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wayhua.lrh2.R;
import com.wayhua.lrh2.data.Resource;
import com.wayhua.lrh2.data.remote.models.BookInfo;
import com.wayhua.lrh2.databinding.FragmentBookinfoListBinding;
import com.wayhua.lrh2.ui.detail.BookDetailActivity;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends LifecycleFragment implements BookInfoListCallback {

    @Inject
    MainListViewModel movieListViewModel;
    FragmentBookinfoListBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBookinfoListBinding.inflate(inflater, container, false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        binding.recyclerView.setAdapter(new BookInfoListAdapter(this));
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        movieListViewModel
                .getBookInfos()
                .observe(this, listResource -> binding.setResource(listResource));

    }

    @Override
    public void onBookInfoClicked(BookInfo bookInfo, View sharedView) {

        String isbn = bookInfo.getIsbn13();
        BookDetailActivity.start(this.getActivity(), isbn);
    }

}
