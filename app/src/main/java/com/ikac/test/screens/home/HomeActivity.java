package com.ikac.test.screens.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ikac.a365scorestest.R;
import com.ikac.test.common.App;
import com.ikac.test.screens.home.dagger.DaggerHomeComponent;
import com.ikac.test.screens.home.dagger.HomeModule;
import com.ikac.test.screens.home.model.HomeListItem;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Home screen of application
 */
public class HomeActivity extends AppCompatActivity implements HomeView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.home_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.home_swipe_view)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    HomePresenter mHomePresenter;

    private HomeAdapter mHomeAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerHomeComponent
                .builder()
                .appComponent(App.getAppComponent())
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);

        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mHomeAdapter = new HomeAdapter(this);

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mHomeAdapter);

        mSwipeRefreshLayout.setRefreshing(true);
        mHomePresenter.loadData();
    }

    @Override
    protected void onDestroy() {
        mHomePresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showGames(List<HomeListItem> games) {
        mSwipeRefreshLayout.setRefreshing(false);
        if (!games.isEmpty()) {
            mHomeAdapter.setGamesList(games);
        }
    }

    @Override
    public void showError() {
        mSwipeRefreshLayout.setRefreshing(false);
        Toast.makeText(this, "Upps. Something went wrong. Please check your internet connection.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRefresh() {
        mHomePresenter.onDestroy();
        mHomePresenter.loadData();
    }
}
