package com.example.sbt_markin_aa.trelolo.model.instances;

import java.util.List;

/**
 * Created by sbt-markin-aa on 19.04.17.
 */

public class Board {
    private int mBoardId;
    private List<Sticker> mStickers;

    public Board(int boardId) {
        mBoardId = boardId;
    }

    public List<Sticker> getStickers() {
        return mStickers;
    }

    public void setStickers(List<Sticker> stickers) {
        mStickers = stickers;
    }
}
