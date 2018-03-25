package com.ikac.test.screens.home;

import android.util.Log;

import com.ikac.test.common.dagger.ActivityScope;
import com.ikac.test.network.interaction.NetworkManager;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Presenter for home screen
 */
@ActivityScope
public class HomePresenter {

    private static final String TAG = HomePresenter.class.getSimpleName();

    private HomeView mHomeView;
    private NetworkManager mNetworkManager;
    private CompositeDisposable mDisposables;

    @Inject
    HomePresenter(HomeView homeView, NetworkManager networkManager) {
        mHomeView = homeView;
        mNetworkManager = networkManager;
        mDisposables = new CompositeDisposable();
    }

    void startPullRequest() {
        // TODO implement pull request timer
        loadData();
    }

    private void loadData() {
        Disposable disposable = mNetworkManager.getGames()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    Log.d(TAG, "Result: " + result.size());
                    mHomeView.showGames(result);
                }, error -> {
                    Log.e(TAG, "Couldn't load games: " + error);
                    mHomeView.showError();
                });

        mDisposables.add(disposable);
    }

    void onDestroy() {
        mDisposables.dispose();
    }
}
