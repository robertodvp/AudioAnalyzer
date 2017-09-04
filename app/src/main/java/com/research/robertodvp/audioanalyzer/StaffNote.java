package com.research.robertodvp.audioanalyzer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.PopupMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.support.v7.widget.AppCompatTextView;
import android.widget.RelativeLayout;

import static android.content.ContentValues.TAG;

import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.research.robertodvp.audioanalyzer.Enums.NoteAltEnum;
import com.research.robertodvp.audioanalyzer.Enums.NoteLast;
import com.research.robertodvp.audioanalyzer.Enums.NoteRestEnum;
import com.research.robertodvp.audioanalyzer.Enums.NoteState;
import com.research.robertodvp.audioanalyzer.View.NoteAltView;
import com.research.robertodvp.audioanalyzer.View.NoteLastView;

/**
 * TODO: document your custom view class.
 */
public class StaffNote extends AppCompatImageView {

    private AppCompatTextView mStaffNoteDisplay=null;
    private View StaffView=null;
    private Context _context=null;
    private NoteState _state=NoteState.UNSELECTED;
    private NoteAltEnum _alt= NoteAltEnum.SINGLE;
    private NoteLast _last= NoteLast.QUARTER;
    private NoteRestEnum _noteRest= NoteRestEnum.NOTE;
    private NoteLastView _lastView = null;
    private String _noteId=null;
    private NoteAltView _noteAltView=null;
    private int _x = 0;
    private int _y = 0;
    private boolean _showaltgraph = false;
    private boolean _showLastGraph = false;
    private boolean _changeNoteLast = false;

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

    public StaffNote(Context context) {
        super(context);
        init(null, 0, context);
    }

    public StaffNote(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0, context);
    }

    public StaffNote(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle, context);
    }

    private void init(AttributeSet attrs, int defStyle, Context context) {

        _context = context;
        _noteId = this.getResources().getResourceEntryName(this.getId());
        _noteId = _noteId.substring(11);
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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
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
                Log.d(TAG, "Before Action State:"+this._state);

                if (_state==NoteState.UNSELECTED){
                    setState(NoteState.SELECTED);
                    selectNoteRestType();
                }else{
                    if(_changeNoteLast){
                        selectNoteRestType();
                    }else {
                        selectAltType();
                    }
                }

                //Log.d(TAG, "After Action State:"+this._state);

                //this.openNewActivity(1);
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


    public void openNewActivity(int Activity){

            switch (Activity){
                case 1:{
                    Intent intent = new Intent(_context, StaffNoteSettingsActivity.class);
                    _context.startActivity(intent);
                    break;}
            }
    }

    /**
    private void selectType() {
        ListPopupWindow popupWindow;
        popupWindow = new ListPopupWindow(_context);

        List<HashMap<String, Object>> data = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("Title", getString(R.string.left));
        map.put("Icon", R.drawable.left);
        data.add(map);
        map = new HashMap<>();
        map.put("Title", getString(R.string.right));
        map.put("Icon", R.drawable.right);
        data.add(map);

        ListAdapter adapter = new SimpleAdapter(
                _context,
                data,
                R.layout.popup_mnu_staffnotety,
                new String[] {"Title", "Icon"}, // These are just the keys that the data uses (constant strings)
                new int[] {R.id.shoe_select_text, R.id.shoe_select_icon}); // The view ids to map the data to

        popupWindow.setAnchorView(StaffView);
        popupWindow.setAdapter(adapter);
        popupWindow.setWidth(400);
        popupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
        popupWindow.show();

    }*/

    public void selectAltType(){

        PopupMenu popupMenu = new PopupMenu(_context, StaffView, Gravity.NO_GRAVITY, R.attr.actionOverflowMenuStyle, 0);
        popupMenu.getMenuInflater().inflate(R.menu.menu_notealtty, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                Toast.makeText(_context, item.getTitle(), Toast.LENGTH_SHORT).show();
                if(item.getTitleCondensed().toString().equals("CNL")){
                    selectNoteRestType();
                }else {
                    _alt = NoteAltEnum.valueOf(item.getTitleCondensed().toString());
                    setVisibleNoteAltImgViews();
                }
                return true;
            }
        });
        //dont forget to show the menu
        popupMenu.show();
    }

    public void selectNoteRestType(){
        //Context wrapper = new ContextThemeWrapper(_context, R.style.popupMenuStyle);
        PopupMenu popupMenu;
        popupMenu = new PopupMenu(_context, StaffView, Gravity.NO_GRAVITY, R.attr.actionOverflowMenuStyle, R.style.popupMenuStyle);
        popupMenu.getMenuInflater().inflate(R.menu.menu_noterest, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                Toast.makeText(_context, item.getTitle(), Toast.LENGTH_SHORT).show();
                _noteRest = NoteRestEnum.valueOf(item.getTitleCondensed().toString());
                selectLastType();
                return true;
            }
        });
        //dont forget to show the menu
        popupMenu.show();
    }

    public void selectLastType(){

        PopupMenu popupMenu = new PopupMenu(_context, StaffView, Gravity.NO_GRAVITY, R.attr.actionOverflowMenuStyle, 0);
        popupMenu.getMenuInflater().inflate(R.menu.menu_notelastty, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                Toast.makeText(_context, item.getTitle(), Toast.LENGTH_SHORT).show();
                _last = NoteLast.valueOf(item.getTitleCondensed().toString());
                setVisibleNoteLastImgViews();
                return true;
            }
        });
        //dont forget to show the menu
        popupMenu.show();
    }

    public void setVisibleNoteAltImgViews(){
        RelativeLayout rStaffView = (RelativeLayout) ((Activity) _context).findViewById(R.id.idRelativeLStaffView);
        TableLayout tblStaffTable = (TableLayout) ((Activity) _context).findViewById(R.id.idStaffActiveNotesTable);
        TableRow tblRowStaffTable = (TableRow) ((Activity) _context).findViewById(R.id.idRowStaffTable);

        if( _alt != NoteAltEnum.REMOVE ) {

            if(_noteAltView == null) {
                _noteAltView = new NoteAltView(_context);
                this.set_showaltgraph(true);
            }

            System.out.println("2X Y : " + _x + " - " + _y);
            System.out.println("tX tY : " + tblStaffTable.getLeft() + " - " + tblStaffTable.getTop());
            System.out.println("trX trY : " + tblRowStaffTable.getLeft() + " - " + tblRowStaffTable.getTop());
            System.out.println("sX sY : " + (_x + tblStaffTable.getLeft()) + " - " + (_y + (int) tblStaffTable.getY()));

            RelativeLayout.LayoutParams params = null;

            params = new RelativeLayout.LayoutParams(24, 48);
            params.topMargin = _y - 162;
            params.leftMargin = _x-20;

            //System.out.println("getRes " + _context.getResources().getIdentifier("drawable/" + nt.getImgFileName(), null, _context.getPackageName()));
            _noteAltView.setImageResource(_context.getResources().getIdentifier("drawable/" + _alt.getImgFileName(), null, _context.getPackageName()));

            params.topMargin = _y + _alt.get_y();
            params.leftMargin = _x + _alt.get_x();
            params.width = _alt.getNoteAltWidth();
            params.height = _alt.getNoteAltHeight();

            _noteAltView.setVisibility(View.VISIBLE);
            _noteAltView.setLayoutParams(params);
            _noteAltView.invalidate();
            _noteAltView.setElevation(1);

            if(_noteAltView.getParent()==null) {
                rStaffView.addView(_noteAltView);
            }
            rStaffView.invalidate();

        }else{
            this.setState(NoteState.UNSELECTED);
            this.set_alt(NoteAltEnum.SINGLE);
            if(_noteAltView!=null) {
                _noteAltView.setImageResource(0);
                _noteAltView.invalidate();
                rStaffView.removeView(_noteAltView);
                rStaffView.invalidate();
                _noteAltView = null;
            }
            if(_lastView!=null) {
                _lastView.setImageResource(0);
                _lastView.invalidate();
                rStaffView.removeView(_lastView);
                rStaffView.invalidate();
                _lastView = null;
            }
        }
        rStaffView = null;
        tblStaffTable = null;
        tblRowStaffTable = null;
    }


    public void setVisibleNoteLastImgViews(){
        RelativeLayout rStaffView = (RelativeLayout) ((Activity) _context).findViewById(R.id.idRelativeLStaffView);
        TableLayout tblStaffTable = (TableLayout) ((Activity) _context).findViewById(R.id.idStaffActiveNotesTable);
        TableRow tblRowStaffTable = (TableRow) ((Activity) _context).findViewById(R.id.idRowStaffTable);
        String drawable_id = "drawable/";

            if(_lastView == null){
                _lastView = new NoteLastView(_context);
                this.set_showLastGraph(true);
            }

            RelativeLayout.LayoutParams params_last = null;

            params_last = new RelativeLayout.LayoutParams(0, 0);
            params_last.topMargin = _y + _last.get_y();
            params_last.leftMargin = _x + _last.get_x();

            if(_noteRest.equals(NoteRestEnum.NOTE)){
                drawable_id += _last.getImgFileNameFig();
            } else {
                drawable_id += _last.getImgFileNameRest();
            }

            _lastView.setImageResource(_context.getResources().getIdentifier(drawable_id, null, _context.getPackageName()));
            params_last.width = _last.get_width();
            params_last.height = _last.get_height();

            _lastView.setVisibility(View.VISIBLE);
            _lastView.setLayoutParams(params_last);
            _lastView.invalidate();
            _lastView.setElevation(1);

            if(_lastView.getParent()==null) {
                rStaffView.addView(_lastView);
            }
            rStaffView.invalidate();

        rStaffView = null;
        tblStaffTable = null;
        tblRowStaffTable = null;

    }

}
