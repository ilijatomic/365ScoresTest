package com.ikac.test.network.interaction;

import com.ikac.test.common.dagger.ActivityScope;
import com.ikac.test.network.api.ServiceApi;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Provide api calls and responses
 */
@Singleton
public final class NetworkManager {

    private ServiceApi mServiceApi;

    @Inject
    public NetworkManager(ServiceApi serviceApi) {
        mServiceApi = serviceApi;
    }
}
