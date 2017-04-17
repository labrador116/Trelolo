package com.example.sbt_markin_aa.trelolo.model.database.cursor_wrappers;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema.PersonTable;

/**
 * Created by sbt-markin-aa on 17.04.17.
 */

public class PersonTableCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public PersonTableCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public int getPersonID(){
        if (getCount()>0){
            return getInt(getColumnIndex("_id"));
        }else{
            return 0;
        }
    }
}
