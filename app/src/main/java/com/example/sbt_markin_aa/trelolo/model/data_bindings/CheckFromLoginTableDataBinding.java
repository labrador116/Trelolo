package com.example.sbt_markin_aa.trelolo.model.data_bindings;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.sbt_markin_aa.trelolo.model.database.cursor_wrappers.LoginTableCursorWrapper;
import com.example.sbt_markin_aa.trelolo.model.database.data_base_helper.TreloloDBHelper;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema;

/**
 * Created by sbt-markin-aa on 13.04.17.
 */

public class CheckFromLoginTableDataBinding {
    public static LoginTableCursorWrapper checkPersonLogin(Context context, String login){
       Cursor cursor= context.getContentResolver().query(
                Uri.parse("content://com.example.sbt_markin_aa.trelolo.model.database.providers.LoginTableContentProvider/login_table"),
                new String[]{"_id"},
                TreloloDBSchema.LoginTable.Columns.LOGIN,
                new  String[]{login},
                null
        );
        return new LoginTableCursorWrapper(cursor);
    }

    public static LoginTableCursorWrapper checkPersonPassword(Context context, String password){
        Cursor cursor= context.getContentResolver().query(
                Uri.parse("content://com.example.sbt_markin_aa.trelolo.model.database.providers.LoginTableContentProvider/login_table"),
                new String[]{"_id"},
                TreloloDBSchema.LoginTable.Columns.PASSWORD,
                new  String[]{password},
                null
        );
        return new LoginTableCursorWrapper(cursor);
    }

    public static void setTestDataInDB(SQLiteDatabase db){

        /*********************************************/
        /*Test values for DB*/
        ContentValues values = new ContentValues();
        values.put(TreloloDBSchema.LoginTable.Columns.LOGIN, "test");
        values.put(TreloloDBSchema.LoginTable.Columns.PASSWORD, "test");
        //context.getContentResolver().insert(Uri.parse("content://com.example.sbt_markin_aa.trelolo.model.database.providers.LoginTableContentProvider/login_table"),values);
        db.insert(TreloloDBSchema.LoginTable.NAME,null,values);
        values = new ContentValues();
        values.put(TreloloDBSchema.LoginTable.Columns.LOGIN, "qwert");
        values.put(TreloloDBSchema.LoginTable.Columns.PASSWORD, "qwert");
        db.insert(TreloloDBSchema.LoginTable.NAME,null,values);
        //context.getContentResolver().insert(Uri.parse("content://com.example.sbt_markin_aa.trelolo.model.database.providers.LoginTableContentProvider/login_table"),values);
        /*********************************************/

    }

}
