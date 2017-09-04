package com.research.robertodvp.audioanalyzer;

import android.net.Uri;

/**
 * Created by robertov on 16/05/2017.
 */

public class Person {
    int mId;
    String mName;
    String mAddress;
    int mAge;
    Uri mAvatarUri;

    public Person(int mId, String mName, String mAddress, int mAge){
        this.mId = mId;
        this.mName = mName;
        this.mAddress = mAddress;
        this.mAge = mAge;
    }
}
