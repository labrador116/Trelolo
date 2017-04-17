package com.example.sbt_markin_aa.trelolo.model.database.cursor_wrappers;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema;

/**
 * Created by sbt-markin-aa on 13.04.17.
 */

public class LoginTableCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public LoginTableCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public boolean checkPerson(){
      if(getCount()>0) {
          int id = getInt(getColumnIndex("_id"));

          return id != 0 ? true : false;
      } else{
          return false;
      }
    }
}
