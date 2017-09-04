package com.research.robertodvp.audioanalyzer.View;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.research.robertodvp.audioanalyzer.Entities.Score;
import com.research.robertodvp.audioanalyzer.R;
import com.research.robertodvp.audioanalyzer.ScoreActivity;
import com.research.robertodvp.audioanalyzer.Tools.StrFormat;

import java.io.Serializable;

import static android.content.ContentValues.TAG;

/**
 * Created by robertov on 15/08/2017.
 */

public class ScoreViewHolderBKP extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnTouchListener {
    private ImageView mScoreThumbImg;
    private TextView mDataTxtName;
    private TextView mDataTxtAuthor;
    public ImageView mTrashImg;
    private Score mScore;
    public View mV;
    public int position;
    public RelativeLayout mLayout;

    public ScoreViewHolderBKP(View v) {
        super(v);
        mV = v;
        mDataTxtName = (TextView)v.findViewById(R.id.dataTxtNameRVW);
        mDataTxtAuthor = (TextView)v.findViewById(R.id.dataTxtAuthorRVW);
        mScoreThumbImg = (ImageView)v.findViewById(R.id.thumbScoreViewRVW);
        mTrashImg = (ImageView)v.findViewById(R.id.trashRVW);
        mLayout = (RelativeLayout)v.findViewById(R.id.relativeLayouthRVW);
        //v.setOnTouchListener(getOnTouch());
    }

    public void populate(Score score, Boolean trashVisibility) {
        this.mScore = score;
        mDataTxtName.setText(StrFormat.fixedLengthString( score.getmScoreName() == null ? "Unknown" : score.getmScoreName(), 50, "right", ' ') );
        mDataTxtAuthor.setText(StrFormat.fixedLengthString( score.getmAuthor().getmName() == null ? "Unknown" : score.getmAuthor().getmName(), 50, "right", ' '));
        //mScoreThumbImg.setVisibility(View.VISIBLE);
        setTrashImgVisibility(trashVisibility);
        /*
        Log.i("#chars getmScoreName()", String.valueOf(score.getmScoreName().length()));
        Log.i("#chars getmName()", String.valueOf(score.getmAuthor().getmName().length()));
        Log.i("#chars mDataTxtName:", String.valueOf(String.valueOf(StrFormat.fixedLengthString( score.getmScoreName() == null ? "Unknown" : score.getmScoreName(), 50, "right",' ') ).length()));
        Log.i("#chars mDataTxtAuthor:", String.valueOf(String.valueOf(StrFormat.fixedLengthString( score.getmAuthor().getmName() == null ? "Unknown" : score.getmAuthor().getmName(), 50, "right",' ') ).length()));
        */
    }

    public void setTrashImgVisibility(boolean visibility){
        if(visibility){
            //mDataTxtName.setText(StrFormat.fixedLengthString(  "Visible" , 50, "right", ' ') );
            mTrashImg.setVisibility(View.VISIBLE);
        } else {
            //mDataTxtName.setText(StrFormat.fixedLengthString(  "Invisble" , 50, "right", ' ') );
            mTrashImg.setVisibility(View.INVISIBLE);
        }
    }


    private View.OnTouchListener getOnTouch() {
        return new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return this.onTouch(v, event);
            }
        };
    }
    @Override
    public final boolean onTouch(View v, MotionEvent event) {
        Toast.makeText(this.mV.getContext(), "Touched layout", Toast.LENGTH_SHORT).show();
        Log.d("TOUCH", "Touched layout");
        Log.i("touched item",this.toString());

        try{
            Intent intent = new Intent(this.mV.getContext(), ScoreActivity.class);
            if(mScore!=null) {
                intent.putExtra("Score", (Serializable) mScore);
            }
            this.mV.getContext().startActivity(intent);
        }
        catch (Exception e){
            Log.w(TAG, "onTouchEvent: ", e);
        }
        return true;
    }
    @Override
    public void onClick(View view){
    }

}
