package com.research.robertodvp.audioanalyzer.View;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.research.robertodvp.audioanalyzer.Entities.Measure;
import com.research.robertodvp.audioanalyzer.Entities.Score;
import com.research.robertodvp.audioanalyzer.R;
import com.research.robertodvp.audioanalyzer.ScoreActivity;
import com.research.robertodvp.audioanalyzer.Tools.StrFormat;

import java.io.Serializable;

import static android.content.ContentValues.TAG;

/**
 * Created by robertov on 16/08/2017.
 */

public class MeasureViewHolder extends UniversalViewHolder {
    private ImageView mMeasureThumbImg;
    private TextView mDataTxtName;
    private TextView mDataTxtId;
    private TextView mDataTxtClef;
    private Measure mMeasure;
    private ImageView mTrashImg;

    public MeasureViewHolder(View v){
        super(v);
        mDataTxtName = (TextView)v.findViewById(R.id.dataMeasureTxtNameRVW);
        mDataTxtId = (TextView)v.findViewById(R.id.dataMeasureTxtIdRVW);
        mDataTxtClef= (TextView)v.findViewById(R.id.dataMeasureTxtClefRVW);
        mMeasureThumbImg = (ImageView)v.findViewById(R.id.thumbMeasureViewRVW);
        super.mTrashImg = (ImageView)v.findViewById(R.id.trashRVW);
    }

    public void populate(Object type, Boolean trashVisibility) {
        this.mMeasure = (Measure) type;
        super.object = type;
        mDataTxtName.setText(StrFormat.fixedLengthString(mMeasure.getmMeasureId() == null ? "Unknown" : mMeasure.getmMeasureId(), 50, "right", ' '));
        mDataTxtId.setText(StrFormat.fixedLengthString(mMeasure.getmMapMeasureId() == null ? "Unknown" : mMeasure.getmMapMeasureId().toString(), 50, "right", ' '));
        mDataTxtClef.setText(StrFormat.fixedLengthString(mMeasure.getmClef() == null ? "Unknown" : mMeasure.getmClef().toString(), 50, "right", ' '));

        mMeasureThumbImg.setVisibility(View.VISIBLE);
        setTrashImgVisibility(trashVisibility);
        /*
        Log.i("#chars getmScoreName()", String.valueOf(score.getmScoreName().length()));
        Log.i("#chars getmName()", String.valueOf(score.getmAuthor().getmName().length()));
        Log.i("#chars mDataTxtName:", String.valueOf(String.valueOf(StrFormat.fixedLengthString( score.getmScoreName() == null ? "Unknown" : score.getmScoreName(), 50, "right",' ') ).length()));
        Log.i("#chars mDataTxtAuthor:", String.valueOf(String.valueOf(StrFormat.fixedLengthString( score.getmAuthor().getmName() == null ? "Unknown" : score.getmAuthor().getmName(), 50, "right",' ') ).length()));
        */
    }

    /*
    @Override
    public void setTrashImgVisibility(boolean visibility){
        if(visibility){
            //mDataTxtName.setText(StrFormat.fixedLengthString(  "Visible" , 50, "right", ' ') );
            mTrashImg.setVisibility(View.VISIBLE);
        } else {
            //mDataTxtName.setText(StrFormat.fixedLengthString(  "Invisble" , 50, "right", ' ') );
            mTrashImg.setVisibility(View.INVISIBLE);
        }
    }*/

}
