package com.research.robertodvp.audioanalyzer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by robertov on 19/03/2017.
 */

public class StaffNoteDisplay extends TextView {

    public StaffNoteDisplay(Context context) {
        super(context);
        init(null, 0);
    }
    public StaffNoteDisplay(Context context,
                             AttributeSet attrs
                             ){
        super(context, attrs);
        init(null, 0);
    }
    public StaffNoteDisplay(Context context,
                             AttributeSet attrs,
                             int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init(null, 0);
    }
    public StaffNoteDisplay(Context context,
                            AttributeSet attrs,
                            int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);
        init(null, 0);
    }

    private void init(AttributeSet attrs, int defStyle) {

    }

}
