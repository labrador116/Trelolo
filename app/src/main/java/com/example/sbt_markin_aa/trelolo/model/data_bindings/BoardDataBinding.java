package com.example.sbt_markin_aa.trelolo.model.data_bindings;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.sbt_markin_aa.trelolo.model.database.cursor_wrappers.BoardTableCursorWrapper;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema;
import com.example.sbt_markin_aa.trelolo.model.instances.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbt-markin-aa on 19.04.17.
 */

public class BoardDataBinding {
    public static List<Board> getAllBoardsForPerson(int personID, Context context){
        List<Board> boards = new ArrayList<>();

        Cursor cursor = context.getContentResolver().query(
                Uri.parse("content://com.example.sbt_markin_aa.trelolo.model.database.providers.TreloloDBContentProvider/"+ TreloloDBSchema.BoardTable.NAME),
                null,
                TreloloDBSchema.BoardTable.Columns.PERSON_ID,
                new String[]{String.valueOf(personID)},
                null
        );

        cursor.moveToFirst();
        BoardTableCursorWrapper cursorWrapper = new BoardTableCursorWrapper(cursor);

        try{
            cursorWrapper.moveToFirst();

            //ToDo The request don't work!
            while(!cursorWrapper.isAfterLast()){
                boards.add(cursorWrapper.getBoard(context));
                cursorWrapper.moveToNext();
            }
        }
        finally {
            cursor.close();
            cursorWrapper.close();
        }

        return boards;
    }
}
