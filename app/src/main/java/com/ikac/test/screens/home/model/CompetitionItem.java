package com.ikac.test.screens.home.model;

/**
 * Created by ikac on 23.3.18..
 */

public class CompetitionItem extends HomeListItem {

    private int id;
    private int cid;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public ItemType getType() {
        return ItemType.COMPETITION;
    }
}
