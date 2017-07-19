package com.wayhua.lrh2.di;



import com.wayhua.lrh2.ui.main.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by mertsimsek on 30/05/2017.
 */
@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract MainFragment contributeMovieListFragment();
}
