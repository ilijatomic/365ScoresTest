package com.ikac.test.network.interaction;

import android.util.Log;
import android.util.SparseArray;

import com.ikac.test.network.api.ServiceApi;
import com.ikac.test.network.model.CompetitionModel;
import com.ikac.test.network.model.CompetitorModel;
import com.ikac.test.network.model.GameModel;
import com.ikac.test.screens.home.model.CompetitionItem;
import com.ikac.test.screens.home.model.GameItem;
import com.ikac.test.screens.home.model.HomeListItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Provide api calls and responses
 */
@Singleton
public final class NetworkManager {

    private static final String TAG = NetworkManager.class.getSimpleName();

    private ServiceApi mServiceApi;
    private SparseArray<CompetitionModel> mCompetitionSparse = new SparseArray<>();
    private HashMap<CompetitionModel, List<GameModel>> mGameMap = new HashMap<>();

    @Inject
    NetworkManager(ServiceApi serviceApi) {
        mServiceApi = serviceApi;
    }

    public Single<List<HomeListItem>> getGames() {
        return mServiceApi.getGames()
                .flatMap(fullModel -> {
                    Log.d(TAG, "getGames: " + fullModel.getLastUpdateId());

                    for (CompetitionModel competitionModel : fullModel.getCompetitionModelList()) {
                        mCompetitionSparse.put(competitionModel.getId(), competitionModel);
                    }

                    for (GameModel gameModel : fullModel.getGameModelList()) {
                        CompetitionModel competitionModel = mCompetitionSparse.get(gameModel.getCompetitionId());

                        if (mGameMap.containsKey(competitionModel)) {
                            mGameMap.get(competitionModel).add(gameModel);
                        } else {
                            List<GameModel> list = new ArrayList<>();
                            list.add(gameModel);
                            mGameMap.put(competitionModel, list);
                        }
                    }

                    List<HomeListItem> result = new ArrayList<>();

                    for (CompetitionModel competition : mGameMap.keySet()) {
                        CompetitionItem competitionItem = new CompetitionItem();
                        competitionItem.setId(competition.getId());
                        competitionItem.setName(competition.getName());
                        competitionItem.setCid(competition.getCid());
                        result.add(competitionItem);

                        for (GameModel game : mGameMap.get(competition)) {
                            GameItem gameItem = new GameItem();
                            CompetitorModel teamOne = game.getCompetitorModelList().get(0);
                            CompetitorModel teamTwo = game.getCompetitorModelList().get(1);
                            gameItem.setTeamOne(teamOne.getName());
                            gameItem.setTeamTwo(teamTwo.getName());
                            gameItem.setTeamOneId(teamOne.getId());
                            gameItem.setTeamTwoId(teamTwo.getId());
                            gameItem.setActive(game.isActive());
                            gameItem.setGameTime(game.getGameTime());
                            gameItem.setStartTime(game.getStartTime());
                            gameItem.setScore(game.getScore());
                            result.add(gameItem);
                        }
                    }

                    Log.d(TAG, "getGames: " + result.size());

                    if (result.isEmpty()) {
                        return null;
                    } else {
                        return Single.just(result);
                    }
                });
    }

}
