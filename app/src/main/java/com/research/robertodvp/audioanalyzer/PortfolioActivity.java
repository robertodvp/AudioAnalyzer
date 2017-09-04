package com.research.robertodvp.audioanalyzer;

import android.os.Bundle;

import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;


import com.research.robertodvp.audioanalyzer.Entities.Author;
import com.research.robertodvp.audioanalyzer.Entities.Instrument;
import com.research.robertodvp.audioanalyzer.Entities.Key;
import com.research.robertodvp.audioanalyzer.Entities.Measure;
import com.research.robertodvp.audioanalyzer.Entities.Score;
import com.research.robertodvp.audioanalyzer.Entities.Timing;
import com.research.robertodvp.audioanalyzer.Enums.ClefEnum;
import com.research.robertodvp.audioanalyzer.Enums.DMLSentence;
import com.research.robertodvp.audioanalyzer.Enums.InstrumentEnum;
import com.research.robertodvp.audioanalyzer.Enums.KeyMode;
import com.research.robertodvp.audioanalyzer.Enums.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class PortfolioActivity extends ParentActivity {

    private ArrayList<Object> arrayUList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        loadToolBar();
        setUpRecyclerView();
    }

    private void setUpRecyclerView()
    {
        try {
            ArrayMap<Integer, ArrayMap<Integer, Object>> setRecycler = new ArrayMap<>();
            ArrayMap<Integer, Object> setObjectsForRecycler = new ArrayMap<>();
            setObjectsForRecycler.put(1,getUScoreData()); //mArrayData
            setObjectsForRecycler.put(2,"Score"); //mEntity
            setObjectsForRecycler.put(3,this.findViewById(R.id.activity_portfolio)); //mViewGrp
            setObjectsForRecycler.put(4,this.findViewById(R.id.recycler_view).getId()); //mRecyclerViewId
            setObjectsForRecycler.put(5,LinearLayoutManager.VERTICAL); //mLinearLayoutManager
            setRecycler.put(1, setObjectsForRecycler);
            super.setmSetObjectsForRecyclers(setRecycler);
            super.setUpUniversalRecyclerView();
        } catch (Exception e){
            Log.e(TAG, "setUpRecyclerView: ",e );
        }
    }


    private ArrayList<Object> getUScoreData() {
        //cargar las scores del portafolio
        List<Instrument> mLInstruments = new ArrayList<Instrument>();
        Score scr1 = new Score("UID1","My Score",new Author(1,"Roberto Velasquez"),"drawable/thumpscore1", getInstruments("UID1"));
        Score scr2 = new Score("UID2","My Score 2",new Author(2,"Beethoven"),"drawable/thumpscore2",getInstruments("UID2"));
        Score scr3 = new Score("UID3","My Score 3",new Author(3,"Frederic Chopin"),"drawable/thumpscore3",getInstruments("UID3"));
        Score scr4 = new Score("UID4","My Score 4",new Author(4,"Rachmaninoff"),"drawable/thumpscore4",getInstruments("UID4"));
        Score scr5 = new Score("UID5","My Score 5",new Author(5,"Johan Sebastian Bach"),"drawable/thumpscore5",getInstruments("UID5"));

        //crear dinámicamente la lista de scores
        arrayUList = new ArrayList<Object>();
        arrayUList.add(scr1);
        arrayUList.add(scr2);
        arrayUList.add(scr3);
        arrayUList.add(scr4);
        arrayUList.add(scr5);

        return arrayUList;

        //2017-08-16 ajustar score para que maneje instrumentos ya que con base en el numero y tipo de instrumento seran las listas de partituras measures que se mostraran para su edicion.
    }

    private ArrayList getInstruments(String scoreId){
        switch (scoreId) {
            case "UID1":
                return new ArrayList<>(Arrays.asList(new Instrument("INSTRUMENT1",InstrumentEnum.PIANO, getMeasures("UID1.1")),new Instrument("INSTRUMENT2",InstrumentEnum.PIANO,getMeasures("UID1.2"))));
            case "UID2":
                return new ArrayList<>(Arrays.asList(new Instrument("INSTRUMENT3",InstrumentEnum.PIANO, getMeasures("UID2.1")),new Instrument("INSTRUMENT4",InstrumentEnum.PIANO,getMeasures("UID2.2")),new Instrument("INSTRUMENT5",InstrumentEnum.PIANO,getMeasures("UID2.3"))));

            default:
                return new ArrayList<>(Arrays.asList(new Instrument("INSTRUMENT6"+scoreId,InstrumentEnum.PIANO, getMeasures("UIDx.1")),new Instrument("INSTRUMENT7"+scoreId,InstrumentEnum.PIANO,getMeasures("UIDx.2"))));
        }
    }

    //Get Measure Data based on Score id
    private Map<Integer, List<Measure>> getMeasures(String uid){
        Map<Integer, List<Measure>> mapMeasures = new HashMap<Integer, List<Measure>>();
        List<Measure> measureList = new ArrayList<Measure>();
        //in theory this should be retrieved from db
        //two for piano, but scores can have multiple instruments
        measureList.add(new Measure(380, ClefEnum.TREBLE, new Key(0, KeyMode.MAJOR), new Timing(),uid, 1, Position.TOP, 0 ));
        measureList.add(new Measure(380, ClefEnum.TREBLE, new Key(0, KeyMode.MAJOR), new Timing(),uid, 2, Position.TOP, 1 ));
        measureList.add(new Measure(380, ClefEnum.TREBLE, new Key(0, KeyMode.MAJOR), new Timing(),uid, 3, Position.TOP,2 ));
        mapMeasures.put(1, measureList);

        List<Measure> measureList2 = new ArrayList<Measure>();

        measureList2.add(new Measure(380, ClefEnum.BASS, new Key(0, KeyMode.MAJOR), new Timing(),uid, 1, Position.DOWN, 0 ));
        measureList2.add(new Measure(380, ClefEnum.BASS, new Key(0, KeyMode.MAJOR), new Timing(),uid, 2,Position.DOWN, 1));
        measureList2.add(new Measure(380, ClefEnum.BASS, new Key(0, KeyMode.MAJOR), new Timing(),uid, 3,Position.DOWN,2 ));
        mapMeasures.put(2, measureList2);

        return mapMeasures;
    }

    //we request DataBase Operator to update ( either insert, update, delete )
    public void updateScoreData(DMLSentence sqlS, Score obj) {
        int i=1;
    }

    //menu tool bar
    /*
    @Override
    public void setActivityState(ActivityStateEnum edit) (){}
    No need yet */

}
