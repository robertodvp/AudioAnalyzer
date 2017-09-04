package com.research.robertodvp.audioanalyzer.Entities;

import com.research.robertodvp.audioanalyzer.Enums.KeyMode;

import java.io.Serializable;

/**
 * Created by robertov on 30/04/2017.
 */

public class Key implements Serializable {

    // Getters and Setters //

    public Integer getmFifths() {
        return mFifths;
    }

    public void setmFifths(Integer mFifths) {
        this.mFifths = mFifths;
    }

    public KeyMode getmKeyMode() {
        return mKeyMode;
    }

    public void setmKeyMode(KeyMode mKeyMode) {
        this.mKeyMode = mKeyMode;
    }


    // Members //
    private Integer mFifths = 0;
    private KeyMode mKeyMode = KeyMode.MAJOR;

    public Key(Integer lFifths, KeyMode lKeyMode){
        this.mFifths = lFifths;
        this.mKeyMode = lKeyMode;
    }

}
