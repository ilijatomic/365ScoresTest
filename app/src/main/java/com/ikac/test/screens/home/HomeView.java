package com.ikac.test.screens.home;

import com.ikac.test.screens.home.model.HomeListItem;

import java.util.List;

/**
 * Interaction with home screen
 */
public interface HomeView {

    void showGames(List<HomeListItem> games);

    void showError();
}
