package com.research.robertodvp.audioanalyzer;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.PopupMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.research.robertodvp.audioanalyzer.Enums.ClefEnum;

import static android.content.ContentValues.TAG;

/**
 * Created by robertov on 21/04/2017.
 */

public class StaffClef extends AppCompatImageView {

    private AppCompatTextView mStaffClefDisplay=null;
    private View StaffView=null;
    private Context _context=null;
    private String _noteId=null;
    private int _x = 0;
    private int _y = 0;
    private ClefEnum _clefType = ClefEnum.TREBLE;

    public ClefEnum getClefType() {
        return _clefType;
    }

    public void setClefType(ClefEnum clefType) {
        this._clefType = clefType;
    }

    public int get_x() {
        return _x;
    }

    public void set_x(int _x) {
        this._x = _x;
    }

    public int get_y() {
        return _y;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    public String get_noteId() {
        return _noteId;
    }

    public void set_noteId(String _noteId) {
        this._noteId = _noteId;
    }

    private void invalidateTextPaintAndMeasurements() {

    }

    public StaffClef(Context context) {
        super(context);
        init(null, 0, context);
    }

    public StaffClef(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0, context);
    }

    public StaffClef(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle, context);
    }

    private void init(AttributeSet attrs, int defStyle, Context context) {
        _context = context;
        _noteId = this.getResources().getResourceEntryName(this.getId());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();

        switch (action) {

            case MotionEvent.ACTION_DOWN:

                int[] location = new int[2];

                this.getLocationInWindow(location);
                this.set_x(location[0]);
                this.set_y(location[1]);
                //System.out.println("iwX iwY : "+_x+" - "+_y);

                LayoutInflater inflater = (LayoutInflater)_context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                StaffView = inflater.inflate(R.layout.activity_staff_view, null );
                AppCompatTextView tmpTV = (AppCompatTextView)((Activity)_context).findViewById(R.id.idStaffNoteDisplayText);
                tmpTV.setText(this.get_noteId());

                StaffView.invalidate();
                Log.d(TAG, "Action was DOWN");

                selectClefType();

                break;

            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "Action was MOVE");
                break;

            case MotionEvent.ACTION_UP:
                float finalX = event.getX();
                float finalY = event.getY();

                Log.d(TAG, "Action was UP");

                /*
                if (initialX < finalX) {
                    Log.d(TAG, "Left to Right swipe performed");
                }

                if (initialX > finalX) {
                    Log.d(TAG, "Right to Left swipe performed");
                }

                if (initialY < finalY) {
                    Log.d(TAG, "Up to Down swipe performed");
                }

                if (initialY > finalY) {
                    Log.d(TAG, "Down to Up swipe performed");
                }
                */

                break;

            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG,"Action was CANCEL");
                break;

            case MotionEvent.ACTION_OUTSIDE:
                Log.d(TAG, "Movement occurred outside bounds of current screen element");
                break;
        }
        return super.onTouchEvent(event);
    }

    public void selectClefType(){

        PopupMenu popupMenu = new PopupMenu(_context, StaffView, Gravity.NO_GRAVITY, R.attr.actionOverflowMenuStyle, 0);
        popupMenu.getMenuInflater().inflate(R.menu.menu_clefty, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                Toast.makeText(_context, item.getTitle(), Toast.LENGTH_SHORT).show();
                _clefType = ClefEnum.valueOf(item.getTitleCondensed().toString());
                setClefImgView();
                return true;
            }
        });
        //dont forget to show the menu
        popupMenu.show();
    }

    public void setClefImgView(){
        RelativeLayout.LayoutParams params = null;
        params = new RelativeLayout.LayoutParams(24, 48);
        params.topMargin = this._clefType.get_y();
        params.leftMargin = this._clefType.get_x();

        this.setImageResource(_context.getResources().getIdentifier("drawable/"+_clefType.getImgFileName(),null,_context.getPackageName()));
        this.setVisibility(View.VISIBLE);
        //this.setLayoutParams(params);
        this.invalidate();
        //this.setElevation(1);

    }
}
