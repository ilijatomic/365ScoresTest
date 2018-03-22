package com.ikac.test.screens.home.dagger;

import com.ikac.test.common.dagger.ActivityScope;
import com.ikac.test.common.dagger.AppComponent;
import com.ikac.test.screens.home.HomeActivity;

import dagger.Component;

/**
 * Provides home module
 */
@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {HomeModule.class})
public interface HomeComponent {

    void inject(HomeActivity homeActivity);
}
