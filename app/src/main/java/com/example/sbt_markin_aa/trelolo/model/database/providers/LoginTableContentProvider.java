package com.example.sbt_markin_aa.trelolo.model.database.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.sbt_markin_aa.trelolo.model.database.data_base_helper.TreloloDBHelper;

/**
 * Created by sbt-markin-aa on 13.04.17.
 */

public class LoginTableContentProvider extends ContentProvider {
    private static final UriMatcher sURI_MATCHER;
    private static final String AUTHORITY = "com.example.sbt_markin_aa.trelolo.model.database.providers.LoginTableContentProvider";

    private SQLiteDatabase mDatabase;

    static{
        sURI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        sURI_MATCHER.addURI(AUTHORITY,"login_table",0);
    }

    @Override
    public boolean onCreate() {
        mDatabase = new TreloloDBHelper(getContext()).getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor = mDatabase.query(uri.getLastPathSegment(),
                projection,
                selection+"=?",
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        mDatabase.insert(uri.getLastPathSegment(),null,values);
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
