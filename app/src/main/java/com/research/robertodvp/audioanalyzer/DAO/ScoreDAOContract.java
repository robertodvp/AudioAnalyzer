package com.research.robertodvp.audioanalyzer.DAO;

import android.content.ContentValues;
import android.content.Intent;
import android.provider.BaseColumns;

import com.research.robertodvp.audioanalyzer.Entities.Score;

/**
 * Created by robertov on 04/09/2017.
 */
public class ScoreDAOContract extends EntityDAOContract implements BaseColumns{
    public static final String TABLE_NAME = "Score";
    //public static final Integer _ID = ;
    public static final String COLUMN_NAME_NAME = "NAME";
    public static final String COLUMN_NAME_AUTHOR_ID = "AUTHOR_ID";
    public static final String COLUMN_NAME_THUMP = "THUMP_PATH";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    private Score objScore = null;

    private ScoreDAOContract(){
        super.SQL_CREATE_ENTRIES = setCreateEntries();
        super.SQL_DELETE_ENTRIES = setDeleteEntries();
        super.TABLE_NAME = setTable();
    }

    private String setCreateEntries(){
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_AUTHOR_ID + INT_TYPE + COMMA_SEP +
                        COLUMN_NAME_THUMP + TEXT_TYPE + " )";
        return SQL_CREATE_ENTRIES;
    }

    private String setDeleteEntries(){
        String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
        return SQL_DELETE_ENTRIES;
    }

    private String setTable() {
        return TABLE_NAME;
    }

    public ContentValues getContentValues(){
        ContentValues values = new ContentValues();
        //values.put(LawyerEntry.ID, id);
        values.put(COLUMN_NAME_NAME, objScore.getmScoreName());
        values.put(COLUMN_NAME_AUTHOR_ID, objScore.getmAuthor().getmId());
        values.put(COLUMN_NAME_THUMP, objScore.getmThumpImg());
        return values;
    }
}
