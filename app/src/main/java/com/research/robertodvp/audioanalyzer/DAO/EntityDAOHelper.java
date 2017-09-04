package com.research.robertodvp.audioanalyzer.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by robertov on 03/09/2017.
 */

public class EntityDAOHelper<T extends EntityDAOContract> extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AudioAnalyzer.db";
    private EntityDAOContract mEntity = null;

    public EntityDAOHelper(Context context, T obj) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mEntity = obj;
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(mEntity.SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(mEntity.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public long saveEntity() {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(
                mEntity.TABLE_NAME,
                null,
                mEntity.getContentValues());
    }
}
