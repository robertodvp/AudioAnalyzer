package com.research.robertodvp.audioanalyzer.View;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.research.robertodvp.audioanalyzer.Entities.Score;
import com.research.robertodvp.audioanalyzer.R;
import com.research.robertodvp.audioanalyzer.Tools.StrFormat;

/**
 * Created by robertov on 28/08/2017.
 */

public class ScoreViewHolder extends UniversalViewHolder  {
    private ImageView mScoreThumbImg;
    private TextView mDataTxtName;
    private TextView mDataTxtAuthor;
    //public ImageView mTrashImg;
    private Score mScore;

    public ScoreViewHolder(View v) {
        super(v);
        mDataTxtName = (TextView)v.findViewById(R.id.dataTxtNameRVW);
        mDataTxtAuthor = (TextView)v.findViewById(R.id.dataTxtAuthorRVW);
        mScoreThumbImg = (ImageView)v.findViewById(R.id.thumbScoreViewRVW);
        super.mTrashImg = (ImageView)v.findViewById(R.id.trashRVW);
    }

    @Override
    public void populate(Object type, Boolean trashVisibility) {
        this.mScore = (Score)type;
        super.object=type;
        mDataTxtName.setText(StrFormat.fixedLengthString( mScore.getmScoreName() == null ? "Unknown" : mScore.getmScoreName(), 50, "right", ' ') );
        mDataTxtAuthor.setText(StrFormat.fixedLengthString( mScore.getmAuthor().getmName() == null ? "Unknown" : mScore.getmAuthor().getmName(), 50, "right", ' '));
        //mScoreThumbImg.setVisibility(View.VISIBLE);
        setTrashImgVisibility(trashVisibility);
        /*
        Log.i("#chars getmScoreName()", String.valueOf(score.getmScoreName().length()));
        Log.i("#chars getmName()", String.valueOf(score.getmAuthor().getmName().length()));
        Log.i("#chars mDataTxtName:", String.valueOf(String.valueOf(StrFormat.fixedLengthString( score.getmScoreName() == null ? "Unknown" : score.getmScoreName(), 50, "right",' ') ).length()));
        Log.i("#chars mDataTxtAuthor:", String.valueOf(String.valueOf(StrFormat.fixedLengthString( score.getmAuthor().getmName() == null ? "Unknown" : score.getmAuthor().getmName(), 50, "right",' ') ).length()));
        */
    }

}
