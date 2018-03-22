package com.ikac.test.network.api;

import com.ikac.test.common.util.Constants;
import com.ikac.test.network.model.FullModel;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Provides connection to api services
 */
public interface ServiceApi {

    /**
     * Get all today games
     *
     * @return Full response {@link FullModel}.
     */
    @GET(Constants.GAMES_URL)
    Single<FullModel> getGames();
}
