package com.research.robertodvp.audioanalyzer.Entities;

import com.research.robertodvp.audioanalyzer.Enums.ClefEnum;
import com.research.robertodvp.audioanalyzer.Enums.NoteFrequency;
import com.research.robertodvp.audioanalyzer.Exceptions.FreqException;
import com.research.robertodvp.audioanalyzer.StaffNote;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by robertov on 01/05/2017.
 */

public class Stave implements Serializable {
    private NoteFrequency mTopLimit;
    private NoteFrequency mDownLimit;
    private Integer mScreenLength=48;
    private Integer mScreenTop=48;
    private Integer mScreenDown=48;
    private ClefEnum mStaveClef;
    private List<StaffNote> mScreenArray;

    // Getters and Setters
    public NoteFrequency getmTopLimit() {
        return mTopLimit;
    }

    public void setmTopLimit(NoteFrequency mTopLimit) {
        this.mTopLimit = mTopLimit;
    }

    public NoteFrequency getmDownLimit() {
        return mDownLimit;
    }

    public void setmDownLimit(NoteFrequency mDownLimit) {
        this.mDownLimit = mDownLimit;
    }

    public Stave (ClefEnum mClef,NoteFrequency mTopLimit, NoteFrequency mDownLimit){
        this.mTopLimit = mTopLimit;
        this.mDownLimit = mDownLimit;
        this.mStaveClef = mClef;
        this.mScreenArray = new ArrayList<>();
        createScreen();
    }

    private void createScreen(){
        Integer _topLimit=0;
        Integer _downLimit=0;
        String _lineOrBlankMask = "C E G B";
        String _completeLineTrebleOctave4 = "E G B";
        String _completeLineTrebleOctave5 = "D F";
        String _skipSharp = "AS GS FS DS CS";

        try{
        //validate if mTopLimit > mDownLimit
            checkFreq();
            //If TREBLE
            if (mStaveClef == ClefEnum.TREBLE) {
                //base note will be G4
                for (NoteFrequency x : NoteFrequency.values()) {

                    if ((x.getmFrequency()<mTopLimit.getmFrequency())||(x.getmFrequency()>mDownLimit.getmFrequency())) {
                        break;
                    } else {
                        if (_skipSharp.indexOf(x.getmNoteName()) >= 0) {
                            continue;
                        } else {
                            //add StaffNote with line style to ScreenArray
                           // mScreenArray.add(new StaffNote());
                        }
                    }


                }
                for (int i = _downLimit ; i <= _topLimit; i++) {
                    //odd numbers in Treble are lines, even blanks
                    if (i % 2 == 0) {
                        System.out.println("You entered an even number.");
                        //add StaffNote with line style to screenArray
                        //check if has to be middle line style


                    } else {
                        System.out.println("You entered an odd number.");
                        //add StaffNote with blank style to screenArray

                    }
                }
            }
        } catch (FreqException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void checkFreq() throws FreqException{
        if(mTopLimit.getmFrequency()>mDownLimit.getmFrequency()) {
            throw new FreqException("Frequencies are not properly set up");
        }
    }
}
