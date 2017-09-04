package com.research.robertodvp.audioanalyzer.View;

import android.content.Context;
import android.content.Intent;
import android.opengl.Visibility;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
 * Created by robertov on 16/05/2017.
 */

public class ScoreThumbView extends LinearLayout {

    private ImageView mScoreThumbImg;
    private TextView mDataTxtName;
    private TextView mDataTxtAuthor;
    private ImageView mTrashImg;
    private Score   mScore;

    public static ScoreThumbView inflate(ViewGroup parent) {
        return (ScoreThumbView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.score_thumb_list_item, parent, false);
    }

    public ScoreThumbView(Context context) {
        super(context);
    }

    public ScoreThumbView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScoreThumbView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mDataTxtName = (TextView) findViewById(R.id.dataTxtName);
        mDataTxtAuthor = (TextView) findViewById(R.id.dataTxtAuthor);
        mScoreThumbImg = (ImageView) findViewById(R.id.thumbScoreView);
        mTrashImg = (ImageView) findViewById(R.id.trash);
    }

    public void populate(Score score) {
        this.mScore = score;
        mDataTxtName.setText(StrFormat.fixedLengthString( score.getmScoreName() == null ? "Unknown" : score.getmScoreName(), 50, "right", ' ') );
        mDataTxtAuthor.setText(StrFormat.fixedLengthString( score.getmAuthor().getmName() == null ? "Unknown" : score.getmAuthor().getmName(), 50, "right", ' '));
        mScoreThumbImg.setVisibility(View.VISIBLE);
        mTrashImg.setVisibility(View.INVISIBLE);
        /*
        Log.i("#chars getmScoreName()", String.valueOf(score.getmScoreName().length()));
        Log.i("#chars getmName()", String.valueOf(score.getmAuthor().getmName().length()));
        Log.i("#chars mDataTxtName:", String.valueOf(String.valueOf(StrFormat.fixedLengthString( score.getmScoreName() == null ? "Unknown" : score.getmScoreName(), 50, "right",' ') ).length()));
        Log.i("#chars mDataTxtAuthor:", String.valueOf(String.valueOf(StrFormat.fixedLengthString( score.getmAuthor().getmName() == null ? "Unknown" : score.getmAuthor().getmName(), 50, "right",' ') ).length()));
        */
    }

    public void setTrashImgVisibility(boolean visibility){
        if(visibility){
            mTrashImg.setVisibility(View.VISIBLE);
        } else {
            mTrashImg.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(this.getContext(), "Touched layout", Toast.LENGTH_SHORT).show();
        Log.d("TOUCH", "Touched layout");
        Log.i("touched item",this.toString());

        try{
            Intent intent = new Intent(this.getContext(), ScoreActivity.class);
            if(mScore!=null) {
                intent.putExtra("Score", (Serializable) mScore);
            }
            this.getContext().startActivity(intent);
        }
        catch (Exception e){
            Log.w(TAG, "onTouchEvent: ", e);
        }
        return true;
    }
}
