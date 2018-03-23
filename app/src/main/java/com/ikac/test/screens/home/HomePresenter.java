package com.ikac.test.screens.home;

import com.ikac.test.common.dagger.ActivityScope;
import com.ikac.test.network.interaction.NetworkManager;

import javax.inject.Inject;

/**
 * Presenter for home screen
 */
@ActivityScope
public class HomePresenter {

    private HomeView mHomeView;
    private NetworkManager mNetworkManager;

    @Inject
    public HomePresenter(HomeView homeView, NetworkManager networkManager) {
        mHomeView = homeView;
        mNetworkManager = networkManager;
    }

    void startPullRequest() {
        // TODO implement pull request timer
        loadData();
    }

    private void loadData() {

    }
}
