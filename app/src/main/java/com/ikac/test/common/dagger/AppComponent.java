package com.ikac.test.common.dagger;

import android.content.Context;

import com.google.gson.Gson;
import com.ikac.test.network.api.ServiceApi;
import com.ikac.test.network.interaction.NetworkManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Providing all common module
 */
@Singleton
@Component(modules = {ContextModule.class, NetworkModule.class, ImageModule.class})
public interface AppComponent {
    Context context();

    ServiceApi serviceApi();

    Gson gson();

    NetworkManager networkManager();
}
