package com.ikac.test.screens.home.model;

/**
 * Created by ikac on 23.3.18..
 */

public abstract class HomeListItem {

    public enum ItemType {
        COMPETITION,
        GAME
    }

    public abstract ItemType getType();
}
