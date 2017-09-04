package com.research.robertodvp.audioanalyzer.Tools;

import android.util.Log;

/**
 * Created by robertov on 10/06/2017.
 */

public class StrFormat {
    public static String fixedLengthString(String string, int length, String leftRight, char chr) {
        Log.i("Length *",String.valueOf(length-string.length()));
        if(leftRight=="left"){
            return String.format("%"+(length)+ "s", string).replace(' ', chr);
        } else {
            return String.format("%-"+(length)+ "s", string).replace(' ', chr);
        }

    }

}
