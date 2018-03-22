package com.ikac.test.network.interaction;

import android.util.SparseArray;

import com.ikac.test.common.dagger.ActivityScope;
import com.ikac.test.network.api.ServiceApi;
import com.ikac.test.network.model.FullModel;
import com.ikac.test.network.model.GameModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Provide api calls and responses
 */
@Singleton
public final class NetworkManager {

    private ServiceApi mServiceApi;
    private SparseArray<List<GameModel>> listSparseArray = new SparseArray<>();

    @Inject
    public NetworkManager(ServiceApi serviceApi) {
        mServiceApi = serviceApi;
    }

    public List<Object> getGames() {

        FullModel fullModel = new FullModel();

        for (GameModel gameModel : fullModel.getGameModelList()) {
            List<GameModel> games = listSparseArray.get(gameModel.getCompetitionId(), new ArrayList<GameModel>());
            if (games.isEmpty()) {
                games.add(gameModel);
                listSparseArray.put(gameModel.getCompetitionId(), games);
            } else {
                games.add(gameModel);
            }
        }

        return null;
    }
}
