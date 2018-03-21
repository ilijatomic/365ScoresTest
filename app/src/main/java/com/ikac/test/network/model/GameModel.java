package com.ikac.test.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ikac on 3/21/18.
 */

public class GameModel extends BaseModel {

    @SerializedName("ID")
    private int id;
    @SerializedName("Comp")
    private int competitorId;
    @SerializedName("Active")
    private boolean active;
    @SerializedName("GT")
    private int gameTime;
    @SerializedName("STime")
    private String startTime;
    @SerializedName("Scrs")
    private int[] score;
    @SerializedName("Comps")
    private List<CompetitorModel> competitorModelList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompetitorId() {
        return competitorId;
    }

    public void setCompetitorId(int competitorId) {
        this.competitorId = competitorId;
    }

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

    public List<CompetitorModel> getCompetitorModelList() {
        return competitorModelList;
    }

    public void setCompetitorModelList(List<CompetitorModel> competitorModelList) {
        this.competitorModelList = competitorModelList;
    }

    @Override
    public String toString() {
        return "GameModel{" +
                "id=" + id +
                ", competitorId=" + competitorId +
                ", active=" + active +
                ", gameTime=" + gameTime +
                ", startTime='" + startTime + '\'' +
                ", score=" + Arrays.toString(score) +
                ", competitorModelList=" + competitorModelList +
                '}';
    }
}
