package com.research.robertodvp.audioanalyzer.Entities;

import java.io.Serializable;

/**
 * Created by robertov on 09/05/2017.
 */

public class Author implements Serializable {


    // Getters and Setters //
    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    // Members //
    private Integer mId = 0;
    private String mName = "";

    public Author(Integer mId, String mName){
        this.mId = mId;
        this.mName = mName;
    }

}
