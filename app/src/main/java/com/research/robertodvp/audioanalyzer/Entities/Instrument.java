package com.research.robertodvp.audioanalyzer.Entities;

import com.research.robertodvp.audioanalyzer.Enums.ClefEnum;
import com.research.robertodvp.audioanalyzer.Enums.InstrumentEnum;
import com.research.robertodvp.audioanalyzer.Enums.KeyMode;
import com.research.robertodvp.audioanalyzer.Enums.Position;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by robertov on 28/08/2017.
 */

public class Instrument implements Serializable {

    // Members //

    public String getmInstrumentId() {
        return mInstrumentId;
    }

    public void setmInstrumentId(String mInstrumentId) {
        this.mInstrumentId = mInstrumentId;
    }

    public InstrumentEnum getmInstrument() {
        return mInstrument;
    }

    public void setmInstrument(InstrumentEnum mInstrument) {
        this.mInstrument = mInstrument;
    }

    public Map<Integer, List<Measure>> getmMMeasure() {
        return mMMeasure;
    }

    public void setmMMeasure(Map<Integer, List<Measure>> mMMeasure) {
        this.mMMeasure = mMMeasure;
    }
    private String mInstrumentId;
    private InstrumentEnum mInstrument;
    private Map<Integer, List<Measure>> mMMeasure;

    public Instrument(InstrumentEnum mInstrument){
        this.mInstrument = mInstrument;
    }

    public Instrument(InstrumentEnum mInstrument, Map<Integer, List<Measure>> mMeasures){
        this.mInstrument = mInstrument;
        this.setmMMeasure(mMeasures);
    }

    public Instrument(String mInstrumentId, InstrumentEnum mInstrument, Map<Integer, List<Measure>> mMeasures){
        this.mInstrument = mInstrument;
        this.setmInstrumentId(mInstrumentId);
        this.setmMMeasure(mMeasures);
    }

    public boolean addMeasure(Integer mBeforeMeasureIndex, Integer mAfterMeasureIndex){
        boolean output = false;

        Integer mNewIndex = this.mMMeasure.size()+1;
        List<Measure> measureList = new ArrayList<Measure>();
        //in theory this should be retrieved from db
        //two for piano, but scores can have multiple instruments
        if(this.mInstrument.getmClefEnum().equals(ClefEnum.GRANDSTAFF)) {
            measureList.add(new Measure(380, ClefEnum.TREBLE, new Key(0, KeyMode.MAJOR), new Timing(), this.mInstrumentId, mNewIndex, Position.TOP, mBeforeMeasureIndex));
            measureList.add(new Measure(380, ClefEnum.BASS, new Key(0, KeyMode.MAJOR), new Timing(), this.mInstrumentId, mNewIndex, Position.DOWN, mBeforeMeasureIndex));
        } else {
            measureList.add(new Measure(380, this.mInstrument.getmClefEnum(), new Key(0, KeyMode.MAJOR), new Timing(), this.mInstrumentId, mNewIndex, Position.TOP, mBeforeMeasureIndex));
        }
        mMMeasure.put(mNewIndex, measureList);

        Measure mMeasureAfterUpdate = this.mMMeasure.get(mAfterMeasureIndex).get(0);
        mMeasureAfterUpdate.setmBeforeMapMeasureId(mNewIndex);
        mMeasureAfterUpdate = this.mMMeasure.get(mAfterMeasureIndex).get(1);
        mMeasureAfterUpdate.setmBeforeMapMeasureId(mNewIndex);

        //refresh screen or reorder list where measures are listed ... {}
        output =true;
        return output;
    }

    public boolean removeMeasure(Integer mMeasureMapIndex, Integer mBeforeMeasureIndex, Integer mAfterMeasureIndex){
        boolean output = false;

        this.mMMeasure.remove(mMeasureMapIndex);

        Measure mMeasureAfterUpdate = this.mMMeasure.get(mAfterMeasureIndex).get(0);
        mMeasureAfterUpdate.setmBeforeMapMeasureId(mBeforeMeasureIndex);
        mMeasureAfterUpdate = this.mMMeasure.get(mAfterMeasureIndex).get(1);
        mMeasureAfterUpdate.setmBeforeMapMeasureId(mBeforeMeasureIndex);

        output = true;
        return output;
    }
}
