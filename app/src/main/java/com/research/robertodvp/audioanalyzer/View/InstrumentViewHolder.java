package com.research.robertodvp.audioanalyzer.View;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.research.robertodvp.audioanalyzer.Entities.Instrument;
import com.research.robertodvp.audioanalyzer.R;
import com.research.robertodvp.audioanalyzer.Tools.StrFormat;

/**
 * Created by robertov on 29/08/2017.
 */

public class InstrumentViewHolder extends UniversalViewHolder {
    private ImageView mInstrumentThumbImg;
    private TextView mDataTxtInstrument;
    private TextView mDataTxtId;
    private Instrument mInstrument;

    public InstrumentViewHolder(View v) {
        super(v);
        mDataTxtInstrument = (TextView)v.findViewById(R.id.dataTxtInstrumentRVW);
        mDataTxtId = (TextView)v.findViewById(R.id.dataTxtIdRVW);
        mInstrumentThumbImg = (ImageView)v.findViewById(R.id.thumbInstrumentViewRVW);
        super.mTrashImg = (ImageView)v.findViewById(R.id.trashRVW);
    }

    @Override
    public void populate(Object type, Boolean trashVisibility) {
        this.mInstrument = (Instrument)type;
        super.object=type;
        mDataTxtInstrument.setText(StrFormat.fixedLengthString( mInstrument.getmInstrument() == null ? "Unknown" : mInstrument.getmInstrument().toString(), 50, "right", ' ') );
        mDataTxtId.setText(StrFormat.fixedLengthString( mInstrument.getmInstrumentId() == null ? "Unknown" : mInstrument.getmInstrumentId(), 50, "right", ' '));
        //mInstrumentThumbImg.setVisibility(View.VISIBLE);
        setTrashImgVisibility(trashVisibility);
        /**
        Log.i("#chars getmScoreName()", String.valueOf(score.getmScoreName().length()));
        Log.i("#chars getmName()", String.valueOf(score.getmAuthor().getmName().length()));
        Log.i("#chars mDataTxtName:", String.valueOf(String.valueOf(StrFormat.fixedLengthString( score.getmScoreName() == null ? "Unknown" : score.getmScoreName(), 50, "right",' ') ).length()));
        Log.i("#chars mDataTxtAuthor:", String.valueOf(String.valueOf(StrFormat.fixedLengthString( score.getmAuthor().getmName() == null ? "Unknown" : score.getmAuthor().getmName(), 50, "right",' ') ).length()));
        */
    }
}
