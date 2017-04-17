package com.example.sbt_markin_aa.trelolo.model.data_bindings;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.sbt_markin_aa.trelolo.model.database.cursor_wrappers.LoginTableCursorWrapper;
import com.example.sbt_markin_aa.trelolo.model.database.cursor_wrappers.PersonTableCursorWrapper;
import com.example.sbt_markin_aa.trelolo.model.database.data_base_helper.TreloloDBHelper;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema.LoginTable;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema.PersonTable;

/**
 * Created by sbt-markin-aa on 13.04.17.
 */

public class CheckFromLoginTableDataBinding {
    public static LoginTableCursorWrapper checkPersonLogin(Context context, String login){
       Cursor cursor= context.getContentResolver().query(
                Uri.parse("content://com.example.sbt_markin_aa.trelolo.model.database.providers.TreloloDBContentProvider/login_table"),
                new String[]{"_id"},
                LoginTable.Columns.LOGIN,
                new  String[]{login},
                null
        );
        return new LoginTableCursorWrapper(cursor);
    }

    public static LoginTableCursorWrapper checkPersonPassword(Context context, String password){
        Cursor cursor= context.getContentResolver().query(
                Uri.parse("content://com.example.sbt_markin_aa.trelolo.model.database.providers.TreloloDBContentProvider/login_table"),
                new String[]{"_id"},
                LoginTable.Columns.PASSWORD,
                new  String[]{password},
                null
        );
        return new LoginTableCursorWrapper(cursor);
    }

    public static int getPersonId(String login, String password, Context context){
        Cursor cursor = context.getContentResolver().query(
                Uri.parse("content://com.example.sbt_markin_aa.trelolo.model.database.providers.TreloloDBContentProvider/login_table/person_id"),
                new String[]{LoginTable.Columns.PERSON_ID},
                LoginTable.Columns.LOGIN +"=? and "+ LoginTable.Columns.PASSWORD +"=?",
                new String[]{login,password},
                null
        );

        cursor.moveToFirst();

       return new LoginTableCursorWrapper(cursor).getIdPerson();
    }

    public static void setTestDataInDB(SQLiteDatabase db){
        ContentValues values = new ContentValues();

        /*********************************************/
        /*Test values for DB*/
        values.put(PersonTable.Columns.Name, "Vasya");
        values.put (PersonTable.Columns.SURNAME, "Jackson");
        db.insert(PersonTable.NAME,null,values);
        /*********************************************/
        values = new ContentValues();
        values.put(PersonTable.Columns.Name, "German");
        values.put (PersonTable.Columns.SURNAME, "Gref");
        db.insert(PersonTable.NAME,null,values);
        /*********************************************/
        values = new ContentValues();
        int personID=1;
        values.put(LoginTable.Columns.PERSON_ID, personID);
        values.put(LoginTable.Columns.LOGIN, "test");
        values.put(LoginTable.Columns.PASSWORD, "test");
        db.insert(LoginTable.NAME,null,values);
        /*********************************************/
        values = new ContentValues();
        personID=2;
        values.put(LoginTable.Columns.PERSON_ID, personID);
        values.put(LoginTable.Columns.LOGIN, "qwert");
        values.put(LoginTable.Columns.PASSWORD, "qwert");
        db.insert(LoginTable.NAME,null,values);
        /*********************************************/

    }

}
