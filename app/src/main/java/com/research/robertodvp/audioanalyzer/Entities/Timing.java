package com.research.robertodvp.audioanalyzer.Entities;

import android.provider.ContactsContract;

import com.research.robertodvp.audioanalyzer.Enums.NoteLast;

import java.io.Serializable;

/**
 * Created by robertov on 30/04/2017.
 */

public class Timing implements Serializable{
    private Integer mBeats;
    private NoteLast mNoteLast;

    //Getters and Setters
    public Integer getmBeats() {
        return mBeats;
    }

    public void setmBeats(Integer mBeats) {
        this.mBeats = mBeats;
    }

    public NoteLast getmNoteLast() {
        return mNoteLast;
    }

    public void setmNoteLast(NoteLast mNoteLast) {
        this.mNoteLast = mNoteLast;
    }

    public Timing(Integer lBeats, NoteLast lNoteLast){
        this.mBeats = lBeats;
        this.mNoteLast = lNoteLast;
    }

    public Timing(){
        this.mBeats = 4;
        this.mNoteLast = NoteLast.QUARTER;
    }
}
