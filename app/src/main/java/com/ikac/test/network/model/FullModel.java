package com.ikac.test.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ikac on 3/21/18.
 */

public class FullModel extends BaseModel {

    @SerializedName("LastUpdateID")
    private int lastUpdateId;
    @SerializedName("Games")
    private List<GameModel> gameModelList = new ArrayList<>();
    @SerializedName("Competitions")
    private List<CompetitionModel> competitionModelList = new ArrayList<>();
    @SerializedName("Countries")
    private List<CountryModel> countryModelList = new ArrayList<>();

    public int getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(int lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public List<GameModel> getGameModelList() {
        return gameModelList;
    }

    public void setGameModelList(List<GameModel> gameModelList) {
        this.gameModelList = gameModelList;
    }

    public List<CompetitionModel> getCompetitionModelList() {
        return competitionModelList;
    }

    public void setCompetitionModelList(List<CompetitionModel> competitionModelList) {
        this.competitionModelList = competitionModelList;
    }

    public List<CountryModel> getCountryModelList() {
        return countryModelList;
    }

    public void setCountryModelList(List<CountryModel> countryModelList) {
        this.countryModelList = countryModelList;
    }

    @Override
    public String toString() {
        return "FullModel{" +
                "lastUpdateId=" + lastUpdateId +
                ", gameModelList=" + gameModelList +
                ", competitionModelList=" + competitionModelList +
                ", countryModelList=" + countryModelList +
                '}';
    }
}
