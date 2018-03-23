package com.ikac.test.screens.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.ikac.a365scorestest.R;
import com.ikac.test.common.App;
import com.ikac.test.screens.home.dagger.DaggerHomeComponent;
import com.ikac.test.screens.home.dagger.HomeModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Home screen of application
 */
public class HomeActivity extends AppCompatActivity implements HomeView {

    @BindView(R.id.home_recycler_view)
    private RecyclerView mRecyclerView;

    @Inject
    HomePresenter mHomePresenter;

    private HomeAdapter mHomeAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerHomeComponent.builder().appComponent(App.getAppComponent()).homeModule(new HomeModule(this)).build().inject(this);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mHomePresenter.startPullRequest();
    }

    @Override
    public void showGames() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void stopProgress() {

    }
}
