package com.research.robertodvp.audioanalyzer.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.support.v7.widget.*;

/**
 * Created by robertov on 23/04/2017.
 */

public class ScoreView extends AppCompatImageView{

    public ScoreView(Context context) {
        super(context);
        init();
    }

    public ScoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //setVisibility(View.INVISIBLE);
        //setBackgroundResource(R.drawable.sharp);
        //setImageResource(R.drawable.sharp);
        //invalidate();
        //setImageResource(R.drawable.sharp);
    }

}
