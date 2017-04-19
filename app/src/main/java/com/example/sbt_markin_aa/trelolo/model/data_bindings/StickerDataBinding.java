package com.example.sbt_markin_aa.trelolo.model.data_bindings;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.example.sbt_markin_aa.trelolo.model.database.cursor_wrappers.StickerTableCursorWrapper;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema;
import com.example.sbt_markin_aa.trelolo.model.instances.Sticker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbt-markin-aa on 17.04.17.
 */

public class StickerDataBinding {
    public static List<Sticker> getAllStickersForPersonBoardById(int personID, int boardId, Context context){
        List<Sticker> stickers = new ArrayList<>();

        Cursor cursor = context.getContentResolver().query(
                Uri.parse("content://com.example.sbt_markin_aa.trelolo.model.database.providers.TreloloDBContentProvider/"+ TreloloDBSchema.StickerTable.NAME+"/all_stickers_from_board"),
                null,
                TreloloDBSchema.StickerTable.Columns.AUTHOR_ID+"=? and "+ TreloloDBSchema.StickerTable.Columns.BOARD_ID+"=?",
                new String[]{String.valueOf(personID), String.valueOf(boardId)},
                null
        );

        StickerTableCursorWrapper cursorWrapper = new StickerTableCursorWrapper(cursor);

        try {

            cursorWrapper.moveToFirst();

            while (!cursorWrapper.isAfterLast()){
                stickers.add(cursorWrapper.getSticker());
                cursorWrapper.moveToNext();
            }
        }
        finally {
            cursor.close();
            cursorWrapper.close();
        }

        return stickers;
    }
}
