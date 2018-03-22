package com.ikac.test.common;

import android.app.Application;

import com.ikac.test.common.dagger.AppComponent;
import com.ikac.test.common.dagger.ContextModule;
import com.ikac.test.common.dagger.DaggerAppComponent;

/**
 * Application object
 */
public class App extends Application {

    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = buildAppComponent();
    }

    private AppComponent buildAppComponent() {
        return DaggerAppComponent.builder().contextModule(new ContextModule(this)).build();
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }
}
