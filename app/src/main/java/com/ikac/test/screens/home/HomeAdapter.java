package com.ikac.test.screens.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ikac.a365scorestest.R;
import com.ikac.test.common.util.Constants;
import com.ikac.test.screens.home.model.CompetitionItem;
import com.ikac.test.screens.home.model.GameItem;
import com.ikac.test.screens.home.model.HomeListItem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ikac on 23.3.18..
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = HomeAdapter.class.getSimpleName();

    private static final int VIEW_TYPE_COMPETITION = 0;
    private static final int VIEW_TYPE_GAME = 1;

    private Context mContext;
    private List<HomeListItem> mGamesList = Collections.emptyList();

    HomeAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view;

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        switch (viewType) {
            case VIEW_TYPE_COMPETITION:
                view = layoutInflater.inflate(R.layout.home_list_item_competition, parent, false);
                viewHolder = new CompetitionViewHolder(view);
                break;
            case VIEW_TYPE_GAME:
                view = layoutInflater.inflate(R.layout.home_list_item_game, parent, false);
                viewHolder = new GameViewHolder(view);
                break;
            default:
                view = layoutInflater.inflate(R.layout.home_list_item_competition, parent, false);
                viewHolder = new CompetitionViewHolder(view);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_COMPETITION:
                CompetitionItem competitionItem = (CompetitionItem) mGamesList.get(position);
                CompetitionViewHolder competitionViewHolder = (CompetitionViewHolder) holder;

                competitionViewHolder.mCompetitionName.setText(competitionItem.getName());
                Glide.with(mContext)
                        .load(String.format(Constants.COMPETITION_LOGO, competitionItem.getCid()))
                        .into(competitionViewHolder.mCompetitionLogo);
                break;
            case VIEW_TYPE_GAME:
                GameItem gameItem = (GameItem) mGamesList.get(position);
                GameViewHolder gameViewHolder = (GameViewHolder) holder;

                gameViewHolder.mTeamOneName.setText(gameItem.getTeamOne());
                gameViewHolder.mTeamTwoName.setText(gameItem.getTeamTwo());

                Glide.with(mContext)
                        .load(String.format(Constants.TEAM_LOGO, gameItem.getTeamOneId()))
                        .into(gameViewHolder.mTeamOneLogo);
                Glide.with(mContext)
                        .load(String.format(Constants.TEAM_LOGO, gameItem.getTeamTwoId()))
                        .into(gameViewHolder.mTeamTwoLogo);

                int[] score = gameItem.getScore();
                if (score[0] != -1 && score[1] != -1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(score[0])
                            .append(" - ")
                            .append(score[1]);

                    gameViewHolder.mScore.setText(stringBuilder.toString());
                    if (!gameItem.isActive()) {
                        gameViewHolder.mScore.setTextColor(mContext.getResources().getColor(android.R.color.holo_red_dark));
                    } else {
                        gameViewHolder.mScore.setTextColor(mContext.getResources().getColor(android.R.color.holo_green_light));
                    }
                } else {

                    DateFormat from = new SimpleDateFormat(Constants.DATE_FORMAT_FROM, Locale.US);
                    DateFormat to = new SimpleDateFormat(Constants.DATE_FORMAT_TO, Locale.US);

                    try {
                        gameViewHolder.mScore.setText(to.format(from.parse(gameItem.getStartTime())));
                    } catch (ParseException e) {
                        Log.e(TAG, "onBindViewHolder: " + e.getMessage());
                    }
                    gameViewHolder.mScore.setTextColor(mContext.getResources().getColor(android.R.color.holo_green_light));
                }

                break;
        }
    }

    @Override
    public int getItemCount() {
        return mGamesList.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (mGamesList.get(position).getType()) {
            case COMPETITION:
                return VIEW_TYPE_COMPETITION;
            case GAME:
                return VIEW_TYPE_GAME;
            default:
                return VIEW_TYPE_COMPETITION;
        }
    }

    void setGamesList(List<HomeListItem> mGamesList) {
        this.mGamesList = mGamesList;
        notifyDataSetChanged();
    }

    static final class CompetitionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.competition_logo)
        ImageView mCompetitionLogo;
        @BindView(R.id.competition_name)
        TextView mCompetitionName;

        CompetitionViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    static final class GameViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.game_team_one_logo)
        ImageView mTeamOneLogo;
        @BindView(R.id.game_team_two_logo)
        ImageView mTeamTwoLogo;
        @BindView(R.id.game_team_one_name)
        TextView mTeamOneName;
        @BindView(R.id.game_team_two_name)
        TextView mTeamTwoName;
        @BindView(R.id.game_score)
        TextView mScore;

        GameViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
