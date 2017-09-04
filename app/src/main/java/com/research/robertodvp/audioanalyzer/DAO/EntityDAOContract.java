package com.research.robertodvp.audioanalyzer.DAO;

import android.content.ContentValues;
import android.provider.BaseColumns;

/**
 * Created by robertov on 04/09/2017.
 */

public abstract class EntityDAOContract {

    public EntityDAOContract(){}
    public String SQL_CREATE_ENTRIES;
    public String SQL_DELETE_ENTRIES;
    public String TABLE_NAME;
    public abstract ContentValues getContentValues();

}
