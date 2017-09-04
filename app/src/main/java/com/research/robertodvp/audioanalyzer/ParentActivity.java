package com.research.robertodvp.audioanalyzer;

import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.research.robertodvp.audioanalyzer.Adapters.UniversalRecyclerViewAdapter;
import com.research.robertodvp.audioanalyzer.Enums.ActivityStateEnum;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ParentActivity extends AppCompatActivity {

    public ArrayList getmArrayData() {
        return mArrayData;
    }
    public void setmArrayData(ArrayList mArrayData) {
        this.mArrayData = mArrayData;
    }
    public String getmEntity() {
        return mEntity;
    }
    public void setmEntity(String mEntity) {
        this.mEntity = mEntity;
    }
    public View getmViewGrp() {
        return mViewGrp;
    }
    public void setmViewGrp(View mViewGrp) {
        this.mViewGrp = mViewGrp;
    }
    public Integer getmRecyclerViewId() {
        return mRecyclerViewId;
    }
    public void setmRecyclerViewId(Integer mRecyclerViewId) {
        this.mRecyclerViewId = mRecyclerViewId;
    }
    public Integer getmLinearLayoutManager() {
        return mLinearLayoutManager;
    }
    public void setmLinearLayoutManager(Integer mLinearLayoutManager) {
        this.mLinearLayoutManager = mLinearLayoutManager;
    }
    public ArrayMap<Integer, ArrayMap<Integer, Object>> getmSetObjectsForRecyclers() {
        return mSetObjectsForRecyclers;
    }
    public void setmSetObjectsForRecyclers(ArrayMap<Integer, ArrayMap<Integer, Object>> mSetOfRecyclers) {
        this.mSetObjectsForRecyclers = mSetOfRecyclers;
    }

    //singles
    private ArrayList mArrayData;
    private String mEntity;
    private UniversalRecyclerViewAdapter mUniversalRecyclerVwAdapter;
    private RecyclerView mRecyclerView;
    private View mViewGrp;
    private Integer mRecyclerViewId;
    private Integer mLinearLayoutManager;

    //array of recyclers
    private ArrayMap<Integer, ArrayMap<Integer, Object>> mSetObjectsForRecyclers;
    private ArrayList<UniversalRecyclerViewAdapter> mSetOfRecyclers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        mSetOfRecyclers = new ArrayList<>();
    }

    //Recycler Views
    public void setUpUniversalRecyclerView()
    {
        try {

            for (ArrayMap.Entry<Integer, ArrayMap<Integer, Object>> pairRec : mSetObjectsForRecyclers.entrySet()) {
                ArrayList tmpArrayData=null;
                String tmpEntity=null;
                View tmpViewGrp=null;
                Integer tmpRecyclerViewId=null;
                Integer tmpLinearLayoutManager=null;
                for (ArrayMap.Entry<Integer, Object> pairObj : pairRec.getValue().entrySet()) {
                    switch(pairObj.getKey()){
                        case 1:
                            tmpArrayData = (ArrayList)pairObj.getValue();
                            break;
                        case 2:
                            tmpEntity = (String)pairObj.getValue();
                            break;
                        case 3:
                            tmpViewGrp = (View)pairObj.getValue();
                            break;
                        case 4:
                            tmpRecyclerViewId = (Integer)pairObj.getValue();
                            break;
                        case 5:
                            tmpLinearLayoutManager = (Integer)pairObj.getValue();
                            break;
                    }
                }

                RecyclerView oRecyclerView = (RecyclerView) tmpViewGrp.findViewById(tmpRecyclerViewId);
                LinearLayoutManager olayoutMngr = new LinearLayoutManager(this, tmpLinearLayoutManager, false);
                oRecyclerView.setLayoutManager(olayoutMngr);
                UniversalRecyclerViewAdapter oUniversalRecyclerVwAdapter = new UniversalRecyclerViewAdapter(tmpArrayData, tmpEntity);
                oRecyclerView.setAdapter(oUniversalRecyclerVwAdapter);
                oRecyclerView.setHasFixedSize(true);
                oUniversalRecyclerVwAdapter.notifyDataSetChanged();
                oRecyclerView.invalidate();
                tmpViewGrp.invalidate();
                //setUpItemTouchHelper(); should be for each recycle...
                //setUpAnimationDecoratorHelper();
                mSetOfRecyclers.add(oUniversalRecyclerVwAdapter);

            }
        } catch (Exception e){
            Log.e(TAG, "setUpRecyclerView: ",e );
        }
    }


    //menu tool bar
    public void loadToolBar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;
            case R.id.action_mnu_item_1:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;
            case R.id.action_edit:
                // Activity state should be Edit
                setActivityState(ActivityStateEnum.EDIT);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    //menu tool bar
    public void setActivityState(ActivityStateEnum edit) {
        switch (edit) {
            case EDIT:
            {
                try{

                    for(UniversalRecyclerViewAdapter objurva : mSetOfRecyclers){
                        if(!objurva.getmObjects().isEmpty()){
                            if (objurva.getTrashVisibility() == true) {
                                objurva.setTrashVisibility(false);
                            } else {
                                objurva.setTrashVisibility(true);
                            }
                            objurva.dataSetChanged();
                        }

                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            default:
                ;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    /**
     * We're gonna setup another ItemDecorator that will draw the red background in the empty space while the items are animating to their new positions
     * after an item is removed.
     */
    /*
    private void setUpAnimationDecoratorHelper() {
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {

            // we want to cache this and not allocate anything repeatedly in the onDraw method
            Drawable background;
            boolean initiated;

            private void init() {
                background = new ColorDrawable(Color.RED);
                initiated = true;
            }

            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

                if (!initiated) {
                    init();
                }

                // only if animation is in progress
                if (parent.getItemAnimator().isRunning()) {

                    // some items might be animating down and some items might be animating up to close the gap left by the removed item
                    // this is not exclusive, both movement can be happening at the same time
                    // to reproduce this leave just enough items so the first one and the last one would be just a little off screen
                    // then remove one from the middle

                    // find first child with translationY > 0
                    // and last one with translationY < 0
                    // we're after a rect that is not covered in recycler-view views at this point in time
                    View lastViewComingDown = null;
                    View firstViewComingUp = null;

                    // this is fixed
                    int left = 0;
                    int right = parent.getWidth();

                    // this we need to find out
                    int top = 0;
                    int bottom = 0;

                    // find relevant translating views
                    int childCount = parent.getLayoutManager().getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View child = parent.getLayoutManager().getChildAt(i);
                        if (child.getTranslationY() < 0) {
                            // view is coming down
                            lastViewComingDown = child;
                        } else if (child.getTranslationY() > 0) {
                            // view is coming up
                            if (firstViewComingUp == null) {
                                firstViewComingUp = child;
                            }
                        }
                    }

                    if (lastViewComingDown != null && firstViewComingUp != null) {
                        // views are coming down AND going up to fill the void
                        top = lastViewComingDown.getBottom() + (int) lastViewComingDown.getTranslationY();
                        bottom = firstViewComingUp.getTop() + (int) firstViewComingUp.getTranslationY();
                    } else if (lastViewComingDown != null) {
                        // views are going down to fill the void
                        top = lastViewComingDown.getBottom() + (int) lastViewComingDown.getTranslationY();
                        bottom = lastViewComingDown.getBottom();
                    } else if (firstViewComingUp != null) {
                        // views are coming up to fill the void
                        top = firstViewComingUp.getTop();
                        bottom = firstViewComingUp.getTop() + (int) firstViewComingUp.getTranslationY();
                    }

                    background.setBounds(left, top, right, bottom);
                    background.draw(c);

                }
                super.onDraw(c, parent, state);
            }

        });
    }
    */
    /**
     * This is the standard support library way of implementing "swipe to delete" feature. You can do custom drawing in onChildDraw method
     * but whatever you draw will disappear once the swipe is over, and while the items are animating to their new position the recycler view
     * background will be visible. That is rarely an desired effect.
     */
    /*
    private void setUpItemTouchHelper() {

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            // we want to cache these and not allocate anything repeatedly in the onChildDraw method
            Drawable background;
            Drawable xMark;
            int xMarkMargin;
            boolean initiated;

            private void init() {
                background = new ColorDrawable(Color.RED);
                xMark = ContextCompat.getDrawable(PortfolioActivity.this, R.drawable.ic_clear_24dp);
                xMark.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                xMarkMargin = (int) PortfolioActivity.this.getResources().getDimension(R.dimen.ic_clear_margin);
                initiated = true;
                //setDefaultSwipeDirs(-140);
            }

            // not important, we don't want drag & drop
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }



            @Override
            public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int position = viewHolder.getAdapterPosition();
                View itemView = viewHolder.itemView;
                TestAdapter testAdapter = (TestAdapter)recyclerView.getAdapter();
                if (testAdapter.isUndoOn() && testAdapter.isPendingRemoval(position)) {
                    return 0;
                }
                Log.d("getSwipeDirs itemviewx",String.valueOf(itemView.getTranslationX()));
                if(itemView.getTranslationX()<-140){
                    return 0;
                }

                return super.getSwipeDirs(recyclerView, viewHolder);
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int swipedPosition = viewHolder.getAdapterPosition();
                Log.d("onSwiped swipedPosition",String.valueOf(viewHolder.getAdapterPosition()));
                TestAdapter adapter = (TestAdapter)mRecyclerView.getAdapter();
                boolean undoOn = adapter.isUndoOn();
                if (undoOn) {
                    adapter.pendingRemoval(swipedPosition);
                } else {
                    //adapter.remove(swipedPosition);
                    Log.d("onSwiped no remove yet",String.valueOf(viewHolder.getAdapterPosition()));
                }
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                View itemView = viewHolder.itemView;

                // not sure why, but this method get's called for viewholder that are already swiped away
                if (viewHolder.getAdapterPosition() == -1) {
                    // not interested in those
                    return;
                }

                Log.d("GetAdapterPostion",String.valueOf(viewHolder.getAdapterPosition()));
                Log.d("itemView Translation X",String.valueOf(itemView.getTranslationX()));
                Log.d("itemView Translation Y",String.valueOf(itemView.getTranslationY()));

                if (!initiated) {
                    init();
                }

                // draw red background
                background.setBounds(itemView.getRight() + (int) dX, itemView.getTop(), itemView.getRight(), itemView.getBottom());
                background.draw(c);

                // draw x mark
                int itemHeight = itemView.getBottom() - itemView.getTop();
                int intrinsicWidth = xMark.getIntrinsicWidth();
                int intrinsicHeight = xMark.getIntrinsicWidth();

                int xMarkLeft = itemView.getRight() - xMarkMargin - intrinsicWidth;
                int xMarkRight = itemView.getRight() - xMarkMargin;
                int xMarkTop = itemView.getTop() + (itemHeight - intrinsicHeight)/2;
                int xMarkBottom = xMarkTop + intrinsicHeight;
                xMark.setBounds(xMarkLeft, xMarkTop, xMarkRight, xMarkBottom);

                xMark.draw(c);

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }

        };
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }
    */

    /*
    private void setUpListView() {
        //cargar layout
        //View vGrp = (View)this.findViewById(R.id.activity_portfolio);

        // Adapter: You need three parameters 'the context, id of the layout (it will be where the data is shown),
        // and the array that contains the data
        adapterScore = new ScoreListAdapter(this,getScoreData());

        // Here, you set the data in your ListView
        list = (ListView) findViewById(R.id.list_item);
        list.setAdapter(adapterScore);
        adapterScore.notifyDataSetChanged();

        list.invalidate();
        vGrp.invalidate();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Log.i("onItemClick",String.valueOf(position));
                Log.i("onItemClick scrname",String.valueOf((TextView)view.findViewById(R.id.dataTxtName)));
            }
        });
    }
    */
}
