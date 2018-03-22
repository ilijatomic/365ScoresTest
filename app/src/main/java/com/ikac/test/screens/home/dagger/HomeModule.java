package com.ikac.test.screens.home.dagger;

import android.support.annotation.NonNull;

import com.ikac.test.common.dagger.ActivityScope;
import com.ikac.test.screens.home.HomeView;

import dagger.Module;
import dagger.Provides;

/**
 * Provides home view methods
 */
@Module
public final class HomeModule {

    private final HomeView mHomeView;

    public HomeModule(@NonNull HomeView homeView) {
        mHomeView = homeView;
    }

    @ActivityScope
    @Provides
    HomeView provideHomeView() {
        return mHomeView;
    }
}
