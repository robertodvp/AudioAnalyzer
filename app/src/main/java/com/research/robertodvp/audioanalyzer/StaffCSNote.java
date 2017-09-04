package com.research.robertodvp.audioanalyzer;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
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
import com.research.robertodvp.audioanalyzer.Enums.NoteAltEnum;
import com.research.robertodvp.audioanalyzer.Enums.NoteLast;
import com.research.robertodvp.audioanalyzer.Enums.NoteRestEnum;
import com.research.robertodvp.audioanalyzer.Enums.NoteState;
import com.research.robertodvp.audioanalyzer.Enums.SignatureEnum;
import com.research.robertodvp.audioanalyzer.View.ClefView;
import com.research.robertodvp.audioanalyzer.View.NoteAltView;
import com.research.robertodvp.audioanalyzer.View.NoteLastView;

import static android.content.ContentValues.TAG;

/**
 * Created by robertov on 21/04/2017.
 */

public class StaffCSNote extends AppCompatImageView {

    private AppCompatTextView mStaffNoteDisplay=null;
    private View StaffView=null;
    private Context _context=null;
    private NoteState _state=NoteState.UNSELECTED;
    private NoteAltEnum _alt= NoteAltEnum.SINGLE;
    private NoteLast _last= NoteLast.QUARTER;
    private NoteRestEnum _noteRest= NoteRestEnum.NOTE;
    private NoteLastView _lastView = null;
    private ClefView _clefView = null;
    private String _noteId=null;
    private NoteAltView _noteAltView=null;
    private int _x = 0;
    private int _y = 0;
    private boolean _showaltgraph = false;
    private boolean _showLastGraph = false;
    private boolean _changeNoteLast = false;
    private boolean _isSignature = false;
    private RelativeLayout _rStaffView = null;

    public boolean is_showaltgraph() {
        return _showaltgraph;
    }

    public void set_showaltgraph(boolean _showaltgraph) {
        this._showaltgraph = _showaltgraph;
    }

    public void set_showLastGraph(boolean _showLastGraph) {
        this._showLastGraph = _showLastGraph;
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

    public NoteAltView get_noteAltView() {
        return _noteAltView;
    }

    public void set_noteAltView(NoteAltView _noteAltView) {
        this._noteAltView = _noteAltView;
    }

    private void invalidateTextPaintAndMeasurements() {

    }

    public NoteState getState(){
        return _state;
    }

    public void setState(NoteState st){
        _state=st;
    }

    public NoteAltEnum get_alt() {
        return _alt;
    }

    public void set_alt(NoteAltEnum _alt) {
        this._alt = _alt;
    }

    public NoteLast get_last() {
        return _last;
    }

    public void set_last(NoteLast _last) {
        this._last = _last;
    }

    public StaffCSNote(Context context) {
        super(context);
        init(null, 0, context);
    }

    public StaffCSNote(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0, context);
    }

    public StaffCSNote(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle, context);
    }

    private void init(AttributeSet attrs, int defStyle, Context context) {

        _context = context;
        _noteId = this.getResources().getResourceEntryName(this.getId());
        _noteId = _noteId.substring(13);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StaffCSNote,
                0, 0);
        try {
            _isSignature = a.getBoolean(R.styleable.StaffCSNote_isSignature, false);
        } finally {
            a.recycle();
        }
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
                LayoutInflater inflater = (LayoutInflater)_context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                StaffView = inflater.inflate(R.layout.activity_staff_view, null );

                if(!_isSignature){
                    selectClefType();
                }else{
                    selectSignatureType();
                }

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

    private void selectSignatureType() {
        PopupMenu popupMenu;
        popupMenu = new PopupMenu(_context, StaffView, Gravity.NO_GRAVITY, R.attr.actionOverflowMenuStyle, 0);
        popupMenu.getMenuInflater().inflate(R.menu.menu_signaturety, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                Toast.makeText(_context, item.getTitle(), Toast.LENGTH_SHORT).show();
                //_clefType = ClefEnum.valueOf(item.getTitleCondensed().toString());
                setSignatureImgView(SignatureEnum.valueOf(item.getTitleCondensed().toString()));
                return true;
            }
        });
        //dont forget to show the menu
        popupMenu.show();
    }

    public void setSignatureImgView(SignatureEnum _signatureEnum) {
        if(_rStaffView == null) {
            _rStaffView = (RelativeLayout) ((Activity) _context).findViewById(R.id.idRelativeLStaffView);
        }
        _clefView = (ClefView)_rStaffView.findViewById(R.id.staffClefId);
        RelativeLayout.LayoutParams params = null;
        params = new RelativeLayout.LayoutParams(24, 48);
        params.topMargin = _signatureEnum.get_y();
        params.leftMargin = _signatureEnum.get_x();
        params.height = _signatureEnum.get_height();
        params.width = _signatureEnum.get_width();
        if(_clefView==null){
            _clefView = new ClefView(_context);
            _clefView.setImageResource(_context.getResources().getIdentifier("drawable/"+_signatureEnum.getImgFileName(),null,_context.getPackageName()));
            _clefView.setVisibility(View.VISIBLE);
            _clefView.setLayoutParams(params);
            _clefView.invalidate();
            _clefView.setElevation(1);
            _clefView.setId(R.id.staffClefId);
            _rStaffView.addView(_clefView);
        } else {
            _clefView.setImageResource(_context.getResources().getIdentifier("drawable/"+_signatureEnum.getImgFileName(),null,_context.getPackageName()));
            _clefView.setVisibility(View.VISIBLE);
            _clefView.setLayoutParams(params);
            _clefView.invalidate();
            _clefView.setElevation(1);
        }
        _rStaffView.invalidate();
    }

    public void selectClefType(){

        PopupMenu popupMenu;
        popupMenu = new PopupMenu(_context, StaffView, Gravity.NO_GRAVITY, R.attr.actionOverflowMenuStyle, 0);
        popupMenu.getMenuInflater().inflate(R.menu.menu_clefty, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                Toast.makeText(_context, item.getTitle(), Toast.LENGTH_SHORT).show();
                //_clefType = ClefEnum.valueOf(item.getTitleCondensed().toString());
                setClefImgView(ClefEnum.valueOf(item.getTitleCondensed().toString()));
                return true;
            }
        });
        //dont forget to show the menu
        popupMenu.show();
    }
    public void setClefImgView(ClefEnum _clefType){
        if(_rStaffView == null) {
            _rStaffView = (RelativeLayout) ((Activity) _context).findViewById(R.id.idRelativeLStaffView);
        }
        _clefView = (ClefView)_rStaffView.findViewById(R.id.staffClefId);
        RelativeLayout.LayoutParams params = null;
        params = new RelativeLayout.LayoutParams(24, 48);
        params.topMargin = _clefType.get_y();
        params.leftMargin = _clefType.get_x();
        params.height = _clefType.get_height();
        params.width = _clefType.get_width();
        if(_clefView==null){
            _clefView = new ClefView(_context);
            _clefView.setImageResource(_context.getResources().getIdentifier("drawable/"+_clefType.getImgFileName(),null,_context.getPackageName()));
            _clefView.setVisibility(View.VISIBLE);
            _clefView.setLayoutParams(params);
            _clefView.invalidate();
            _clefView.setElevation(1);
            _clefView.setId(R.id.staffClefId);
            _rStaffView.addView(_clefView);
        } else {
            _clefView.setImageResource(_context.getResources().getIdentifier("drawable/"+_clefType.getImgFileName(),null,_context.getPackageName()));
            _clefView.setVisibility(View.VISIBLE);
            _clefView.setLayoutParams(params);
            _clefView.invalidate();
            _clefView.setElevation(1);
        }
        _rStaffView.invalidate();
    }

}
