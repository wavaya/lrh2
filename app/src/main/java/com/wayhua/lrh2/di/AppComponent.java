package com.wayhua.lrh2.di;

import android.app.Application;


import com.wayhua.lrh2.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;


@Singleton
@Component(modules = {
        AppModule.class,

        AndroidInjectionModule.class,
        ActivityBuilderModule.class})
public interface  AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

         AppComponent build();
    }

    void inject(App aaApp);
}
