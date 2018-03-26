package com.ikac.test.screens.home;

import android.util.Log;

import com.ikac.test.common.dagger.ActivityScope;
import com.ikac.test.common.util.Constants;
import com.ikac.test.common.util.NetworkUtils;
import com.ikac.test.network.interaction.NetworkManager;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
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

    void startPolling() {
        Disposable disposable = Observable.interval(0, Constants.SYNC_INTERVAL, TimeUnit.SECONDS)
                .filter(t -> NetworkUtils.isOnlineMode())
                .subscribe(this::loadData);

        mDisposables.add(disposable);
    }

    private void loadData(long value) {
        mNetworkManager.getGames()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    Log.d(TAG, "Result: " + result.size());
                    mHomeView.showGames(result);
                }, error -> {
                    Log.e(TAG, "Couldn't load games: " + error);
                    mHomeView.showError();
                });
    }

    void clear() {
        mDisposables.clear();
    }

    void onDestroy() {
        mDisposables.dispose();
    }
}
