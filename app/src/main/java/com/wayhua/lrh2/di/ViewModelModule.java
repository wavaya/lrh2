package com.wayhua.lrh2.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;


import com.wayhua.lrh2.ui.detail.BookDetailViewModel;
import com.wayhua.lrh2.ui.main.MainListViewModel;
import com.wayhua.lrh2.viewmodel.BookInofViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by 黄卫华(wayhua@126.com) on 2017/7/17.
 */
@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainListViewModel.class)
    abstract ViewModel bindsBookInfoListViewModel(MainListViewModel movieListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(BookDetailViewModel.class)
    abstract ViewModel bindsBookInfoDetailViewModel(MainListViewModel movieListViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(BookInofViewModelFactory movieViewModelFactory);

}
