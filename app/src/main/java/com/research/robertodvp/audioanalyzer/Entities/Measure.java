package com.research.robertodvp.audioanalyzer.Entities;

import com.research.robertodvp.audioanalyzer.Enums.ClefEnum;
import com.research.robertodvp.audioanalyzer.Enums.KeyMode;
import com.research.robertodvp.audioanalyzer.Enums.NoteFrequency;
import com.research.robertodvp.audioanalyzer.Enums.Position;

import java.io.Serializable;
import java.security.PrivateKey;
import java.util.ArrayList;

/**
 * Created by robertov on 30/04/2017.
 */

public class Measure implements Serializable {

    private String mMeasureId;
    private Integer mDivisions;
    private Key mKey;
    private Timing mTime;
    private Stave  mStave;
    //private Stave  mStaveDown;
    private ClefEnum mClef;
    //private ClefEnum mClefDown;
    private Integer mMapMeasureId;
    private Integer mBeforeMapMeasureId;
    //private Instruments mInstrument;
    private Position mPosition;


    /// Getters and Setters
    public ClefEnum getmClef() {
        return mClef;
    }
    public void setmClef(ClefEnum mClef) {
        this.mClef = mClef;
    }
    public void setmBeforeMapMeasureId(Integer mBeforeMapMeasureId){
        this.mBeforeMapMeasureId = mBeforeMapMeasureId;
    }
    public Integer getmDivisions() {
        return mDivisions;
    }

    public void setmDivisions(Integer mDivisions) {
        this.mDivisions = mDivisions;
    }

    public Key getmKey() {
        return mKey;
    }

    public void setmKey(Key mKey) {
        this.mKey = mKey;
    }

    public Timing getmTime() {
        return mTime;
    }

    public void setmTime(Timing mTime) {
        this.mTime = mTime;
    }

    public String getmMeasureId() {
        return mMeasureId;
    }

    public void setmMeasureId(String mMeasureId) {
        this.mMeasureId = mMeasureId;
    }

    public Integer getmMapMeasureId() {
        return mMapMeasureId;
    }

    public void setmMapMeasureId(Integer mMapMeasureId) {
        this.mMapMeasureId = mMapMeasureId;
    }

    public Measure(Integer mDivisions, ClefEnum mClef, Key mKey, Timing mTime, String mMeasureId, Integer mMapMeasureId, Position mPosition, Integer mBeforeMapMesureId) {
        this.mDivisions = mDivisions;
        this.mKey = mKey;
        this.mTime = mTime;
        this.mClef = mClef;
        //this.mClefDown = mClefDown;
        this.mMeasureId = mMeasureId;
        this.mMapMeasureId = mMapMeasureId;
        this.mBeforeMapMeasureId = mBeforeMapMesureId;
        setStave(this.mClef);
        //setStave(1,this.mClefDown);
        this.mPosition=mPosition;
    }
    public Measure(){
        this.mDivisions = 380;
        this.mKey.setmFifths(0);
        this.mKey.setmKeyMode(KeyMode.MAJOR);
        this.mClef = ClefEnum.TREBLE;
        //this.mClefDown = ClefEnum.BASS;
        this.mStave = new Stave(this.mClef, NoteFrequency.E6, NoteFrequency.F3);
        //this.mStaveDown = new Stave(ClefEnum.BASS, NoteFrequency.A4, NoteFrequency.A1);
    }

    private void setStave(ClefEnum clefEnum){
        if(clefEnum.equals(ClefEnum.TREBLE)){
            this.mStave = new Stave(clefEnum, NoteFrequency.E6, NoteFrequency.F3);
        } else{
            this.mStave = new Stave(clefEnum, NoteFrequency.A4, NoteFrequency.A1);
        }
    }

    public void setCustomStave(NoteFrequency mTopFreq, NoteFrequency mDownFreq){
        this.mStave.setmTopLimit(mTopFreq);
        this.mStave.setmDownLimit(mDownFreq);
    }

}
