package com.research.robertodvp.audioanalyzer.View;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by robertov on 26/03/2017.
 */

public class NoteAltView extends android.support.v7.widget.AppCompatImageView {
    public NoteAltView(Context context) {
        super(context);

        init();
    }

    public NoteAltView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NoteAltView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public NoteAltView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
