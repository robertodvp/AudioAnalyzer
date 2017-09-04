package com.research.robertodvp.audioanalyzer.Entities;

import com.research.robertodvp.audioanalyzer.Enums.ClefEnum;
import com.research.robertodvp.audioanalyzer.Enums.InstrumentEnum;
import com.research.robertodvp.audioanalyzer.Enums.KeyMode;
import com.research.robertodvp.audioanalyzer.Enums.Position;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by robertov on 23/04/2017.
 */

public class Score implements Serializable {

    /// Members ///
    private String mScoreName;
    private String mScoreId;
    private Author mAuthor;
    private String mThumpImg;
    private List<Instrument> mInstruments;

    /// Getters and Setters
    public List<Instrument> getmInstruments() {
        return mInstruments;
    }

    public void setmInstruments(List<Instrument> mInstruments) {
        this.mInstruments = mInstruments;
    }

    public String getmScoreName() {
        return mScoreName;
    }

    public void setmScoreName(String mScoreName) {
        this.mScoreName = mScoreName;
    }

    public String getmScoreId() {
        return mScoreId;
    }

    public void setmScoreId(String mScoreId) {
        this.mScoreId = mScoreId;
    }

    public Author getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(Author mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getmThumpImg() {
        return mThumpImg;
    }

    public void setmThumpImg(String mThumpImg) {
        this.mThumpImg = mThumpImg;
    }

    public Score( String mScoreId, String mScoreName, Author mAuthor, String mThumpImg, ArrayList<Instrument> mInstruments) {
        this.mScoreName = mScoreName;
        this.mScoreId = mScoreId;
        this.mAuthor = mAuthor;
        this.mThumpImg = mThumpImg;
        this.mInstruments = mInstruments;
    }

    public Score(String mScoreId, String mScoreName,  Author mAuthor, String mThumpImg) {
        this.mScoreName = mScoreName;
        this.mScoreId = mScoreId;
        this.mAuthor = mAuthor;
        this.mThumpImg = mThumpImg;
    }

    public Score() {
        //Default
    }

    public boolean addInstrument(Instrument _mInstrument){
        boolean output = false;

        //in theory this should be retrieved from db
        if(_mInstrument.equals(null)) {
            this.mInstruments.add(_mInstrument);
        } else
        {
            this.mInstruments.add(new Instrument(InstrumentEnum.PIANO));
        }

        output =true;
        return output;
    }

    public boolean removeInstrument(String mInstrumentId){
        boolean output = false;

        for(Instrument i_instrument : this.mInstruments  ){
            if(i_instrument.getmInstrumentId().equals(mInstrumentId)){
                this.mInstruments.remove(i_instrument);
            }
        }

        output = true;
        return output;
    }
}
