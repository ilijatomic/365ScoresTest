package com.ikac.test.screens.home.model;

/**
 * Created by ikac on 23.3.18..
 */

public class GameItem extends HomeListItem {

    private boolean active;
    private int gameTime;
    private String startTime;
    private int[] score = new int[2];
    private String teamOne;
    private String teamTwo;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    @Override
    public ItemType getType() {
        return ItemType.GAME;
    }
}
