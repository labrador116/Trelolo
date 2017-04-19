package com.example.sbt_markin_aa.trelolo.model.database.data_base_helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sbt_markin_aa.trelolo.model.data_bindings.CheckFromLoginTableDataBinding;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema.BoardTable;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema.LoginTable;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema.PersonTable;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema.StickerTable;

/**
 * Created by sbt-markin-aa on 13.04.17.
 */

public class TreloloDBHelper extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String DATABASE_NAME = "treloloDB.db";

    private Context mContext;

    public TreloloDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        mContext=context;
    }

    public TreloloDBHelper(Context context, String name) {
        super(context, name, null, VERSION);
        mContext=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + PersonTable.NAME+
                " ( "+
                "_id integer primary key autoincrement, "+
                PersonTable.Columns.Name + ", "+
                PersonTable.Columns.SURNAME +
                " ) "
        );
        db.execSQL("create table " + LoginTable.NAME +
                " ( "+
                        "_id integer primary key autoincrement, "+
                        LoginTable.Columns.PERSON_ID + ", "+
                        LoginTable.Columns.LOGIN + ", "+
                        LoginTable.Columns.PASSWORD +
                " ) "
        );
        db.execSQL("create table "+ StickerTable.NAME +
                " ( "+
                "_id integer primary key autoincrement, "+
                StickerTable.Columns.AUTHOR_ID +", "+
                StickerTable.Columns.TITLE +", "+
                StickerTable.Columns.TEXT + ", "+
                StickerTable.Columns.BOARD_ID +
                " ) "
        );
        db.execSQL("create table "+ BoardTable.NAME +
                " ( "+
                "_id integer primary key autoincrement, "+
                BoardTable.Columns.PERSON_ID +
                " ) "
        );




        CheckFromLoginTableDataBinding.setTestDataInDB(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
