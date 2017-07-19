package com.wayhua.lrh2.di;

import com.wayhua.lrh2.ui.detail.BookDetailActivity;
import com.wayhua.lrh2.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by mertsimsek on 30/05/2017.
 */
@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract BookDetailActivity bookDetailActivity();
}
