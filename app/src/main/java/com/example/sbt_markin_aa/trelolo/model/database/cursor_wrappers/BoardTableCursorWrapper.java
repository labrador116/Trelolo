package com.example.sbt_markin_aa.trelolo.model.database.cursor_wrappers;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.sbt_markin_aa.trelolo.model.data_bindings.StickerDataBinding;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema.BoardTable;
import com.example.sbt_markin_aa.trelolo.model.instances.Board;
import com.example.sbt_markin_aa.trelolo.model.instances.Sticker;

import java.util.List;

/**
 * Created by sbt-markin-aa on 19.04.17.
 */

public class BoardTableCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public BoardTableCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Board getBoard(Context context){
        int boardId = getInt(getColumnIndex("_id"));
        int personId = getInt(getColumnIndex(BoardTable.Columns.PERSON_ID));
        List<Sticker> stickers = StickerDataBinding.getAllStickersForPersonBoardById(boardId,personId,context);

        Board board = new Board(boardId);
        board.setStickers(stickers);

        return board;

    }
}
