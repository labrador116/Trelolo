package com.example.sbt_markin_aa.trelolo.model.database.data_base_helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.sbt_markin_aa.trelolo.model.database.data_base_helper.TreloloDBHelper;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by sbt-markin-aa on 14.04.17.
 */

@RunWith(AndroidJUnit4.class)
public class TreloloDBHelperTest {
    private static final String TEST_DB_NAME = "test_trelolo.db";
    private TreloloDBHelper mHelper;

    @Test
    public void testCreationDB(){
        mHelper = new TreloloDBHelper(InstrumentationRegistry.getTargetContext(), TEST_DB_NAME);
        SQLiteDatabase db = mHelper.getWritableDatabase();
        Cursor cursor = null;

        try{
            cursor = db.query(TreloloDBSchema.LoginTable.NAME, null,null,null, null, null, null);
            Assert.assertThat(cursor, notNullValue());
        }
        finally {
            if(cursor!=null){
                cursor.close();
            }
            db.close();
        }
    }

    @After
    public void tearDown() {
        InstrumentationRegistry.getContext().deleteDatabase(TEST_DB_NAME);
    }
}
