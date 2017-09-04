package com.research.robertodvp.audioanalyzer.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by robertov on 21/04/2017.
 */

public class ClefView extends android.support.v7.widget.AppCompatImageView{

    public ClefView(Context context) {
        super(context);

        init();
    }

    public ClefView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClefView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ClefView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
