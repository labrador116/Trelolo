package com.example.sbt_markin_aa.trelolo.model.database.cursor_wrappers;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema.StickerTable;
import com.example.sbt_markin_aa.trelolo.model.instances.Sticker;

/**
 * Created by sbt-markin-aa on 17.04.17.
 */

public class StickerTableCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public StickerTableCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Sticker getSticker (){
        int authorID = getInt(getColumnIndex(StickerTable.Columns.AUTHOR_ID));
        String title = getString(getColumnIndex(StickerTable.Columns.TITLE));
        String text = getString(getColumnIndex(StickerTable.Columns.TEXT));

        return new Sticker(authorID,title,text);
    }
}
