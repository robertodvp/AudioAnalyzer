package com.research.robertodvp.audioanalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.research.robertodvp.audioanalyzer.Entities.Instrument;
import com.research.robertodvp.audioanalyzer.Entities.Measure;
import com.research.robertodvp.audioanalyzer.Enums.DMLSentence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * Created by robertov on 29/08/2017.
 */

public class InstrumentActivity extends ParentActivity {

    //private ArrayAdapter<MeasureThumbView> adapter;
    private ArrayList<Measure> arrayList;
    private Instrument mInstrument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument);
        loadToolBar();
        Intent i = getIntent();
        mInstrument = (Instrument)i.getSerializableExtra("Instrument");
        setUpRecyclerView();
    }

    private void setUpRecyclerView()
    {
        try {
            //Set Recycler
            for (Map.Entry<Integer, List<Measure>> pair : mInstrument.getmMMeasure().entrySet()) {
                ArrayMap<Integer, ArrayMap<Integer, Object>> setRecycler = new ArrayMap<>();
                ArrayMap<Integer, Object> setObjectsForRecycler = new ArrayMap<>();
                setObjectsForRecycler.put(1, getMeasureData(pair.getValue())); //mArrayData
                setObjectsForRecycler.put(2, "Measure"); //mEntity
                setObjectsForRecycler.put(3, this.findViewById(R.id.activity_instrument)); //mViewGrp
                if(pair.getKey() == 1) {
                    setObjectsForRecycler.put(4, this.findViewById(R.id.recycler_view_top).getId()); //mRecyclerViewId
                }else{
                    setObjectsForRecycler.put(4, this.findViewById(R.id.recycler_view_down).getId()); //mRecyclerViewId
                }
                setObjectsForRecycler.put(5, LinearLayoutManager.HORIZONTAL); //mLinearLayoutManager
                setRecycler.put(pair.getKey(), setObjectsForRecycler);
                super.setmSetObjectsForRecyclers(setRecycler);
                super.setUpUniversalRecyclerView();
            }

        } catch (Exception e){
            Log.e(TAG, "setUpRecyclerView: "+e.getMessage(),e );
        }
    }

    //we request DataBase Operator to update ( either insert, update, delete )
    public void updateMeasureData(DMLSentence sqlS) {
        int i=1;
    }

    private ArrayList<Measure> getMeasureData(List<Measure> pair) {
        arrayList = new ArrayList<Measure>();
        for (Measure itemMeasure : pair) {
            arrayList.add(itemMeasure);
        }
        return arrayList;
    }
}
