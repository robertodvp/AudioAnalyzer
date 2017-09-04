package com.research.robertodvp.audioanalyzer.View;


import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

//import com.research.robertodvp.audioanalyzer.Gestures.RowGesture;
import com.research.robertodvp.audioanalyzer.R;

/**
 * ViewHolder capable of presenting two states: "normal" and "undo" state.
 */

public class TestViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTextView;
    public Button undoButton;
    public ViewGroup cell;
    public ViewGroup cellContainer;
    private GestureDetectorCompat gestureDetector;

    public TestViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false));
        cell = (ViewGroup)parent.findViewById(R.id.row_view);
        titleTextView = (TextView) itemView.findViewById(R.id.title_text_view);
        undoButton = (Button) itemView.findViewById(R.id.undo_button);

        /*
        gestureDetector=new GestureDetectorCompat(parent.getContext(),new RowGesture());
        cell.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(gestureDetector.onTouchEvent(event)){
                    return true;
                }

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(isScrolling ) {
                        isScrolling  = false;
                        handleScrollFinished();
                    };
                }
                else if(event.getAction() == MotionEvent.ACTION_CANCEL){
                    if(isScrolling ) {
                        isScrolling  = false;
                        handleScrollFinished();
                    };
                }
                return false;
            }
        });
        //https://stackoverflow.com/questions/20797099/swipe-listview-item-from-right-to-left-show-delete-button
        */
    }



}
