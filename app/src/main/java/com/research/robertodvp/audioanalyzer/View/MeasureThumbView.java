package com.research.robertodvp.audioanalyzer.View;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.research.robertodvp.audioanalyzer.Entities.Measure;
import com.research.robertodvp.audioanalyzer.Entities.Score;
import com.research.robertodvp.audioanalyzer.R;
import com.research.robertodvp.audioanalyzer.Tools.StrFormat;

/**
 * Created by robertov on 12/07/2017.
 */

public class MeasureThumbView extends LinearLayout {
    private ImageView mMeasureThumbImg;
    private TextView mDataTxtName;
    private TextView mDataTxtId;
    private ImageView mTrashImg;
    private Measure mMeasure;


    public static MeasureThumbView inflate(ViewGroup parent) {
        return (MeasureThumbView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.measure_thumb_list_item, parent, false);
    }

    public MeasureThumbView(Context context) {
        super(context);
    }

    public MeasureThumbView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureThumbView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mDataTxtName = (TextView) findViewById(R.id.dataTxtName);
        mDataTxtId = (TextView) findViewById(R.id.dataTxtId);
        mMeasureThumbImg = (ImageView) findViewById(R.id.thumbMeasureView);
        mTrashImg = (ImageView) findViewById(R.id.trash);
    }

    public void populate(Measure measure) {
        this.mMeasure = measure;
        mDataTxtName.setText(StrFormat.fixedLengthString( measure.getmMeasureId() == null ? "Unknown" : measure.getmMeasureId(), 50, "right", ' ') );
        mDataTxtId.setText(StrFormat.fixedLengthString( measure.getmMapMeasureId() == null ? "Unknown" : measure.getmMapMeasureId().toString(), 50, "right", ' '));
        mMeasureThumbImg.setVisibility(View.VISIBLE);
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
        Log.d("TOUCH", "Touched layout to open Measure Activity");
        Log.i("touched item",this.toString());
        return true;
    }
}
