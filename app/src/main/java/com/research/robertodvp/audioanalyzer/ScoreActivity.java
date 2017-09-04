package com.research.robertodvp.audioanalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.research.robertodvp.audioanalyzer.Entities.Instrument;
import com.research.robertodvp.audioanalyzer.Entities.Score;
import com.research.robertodvp.audioanalyzer.Enums.DMLSentence;

import java.util.ArrayList;
import static android.content.ContentValues.TAG;

public class ScoreActivity extends ParentActivity {

    //private ArrayAdapter<MeasureThumbView> adapter;
    private ArrayList<Instrument> arrayList;
    private Score mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        loadToolBar();
        Intent i = getIntent();
        mScore = (Score)i.getSerializableExtra("Score");
        setUpRecyclerView();
    }

    private void setUpRecyclerView()
    {
        try {
            //Set Recycler
            ArrayMap<Integer, ArrayMap<Integer, Object>> setRecycler = new ArrayMap<>();
            ArrayMap<Integer, Object> setObjectsForRecycler = new ArrayMap<>();
            setObjectsForRecycler.put(1,getInstrumentData()); //mArrayData // Here we get data from data source
            setObjectsForRecycler.put(2,"Instrument"); //mEntity
            setObjectsForRecycler.put(3,this.findViewById(R.id.activity_score)); //mViewGrp
            setObjectsForRecycler.put(4,this.findViewById(R.id.recycler_view).getId()); //mRecyclerViewId
            setObjectsForRecycler.put(5,LinearLayoutManager.VERTICAL); //mLinearLayoutManager
            setRecycler.put(1, setObjectsForRecycler);
            super.setmSetObjectsForRecyclers(setRecycler);
            super.setUpUniversalRecyclerView();
        } catch (Exception e){
            Log.e(TAG, "setUpRecyclerView: "+e.getMessage(),e );
        }
    }

    //we request DataBase Operator to update ( either insert, update, delete )
    public void updateInstrumentData(DMLSentence sqlS) {
        int i=1;
    }

    private ArrayList<Instrument> getInstrumentData() {
        arrayList = new ArrayList<Instrument>();
        for (Instrument instrument : mScore.getmInstruments()){
            arrayList.add(instrument);
        }
        return arrayList;
    }

    //menu tool bar
    /*
    @Override
    public void setActivityState(ActivityStateEnum edit) (){}
    No need yet */

    /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {}
    No need yet */

}
