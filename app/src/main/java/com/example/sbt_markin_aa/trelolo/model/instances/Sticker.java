package com.example.sbt_markin_aa.trelolo.model.instances;

/**
 * Created by sbt-markin-aa on 17.04.17.
 */

public class Sticker {
    private int mAuthorID;
    private String mTitle;
    private String mText;

    public Sticker(int authorID, String title, String text) {
        mAuthorID = authorID;
        mTitle = title;
        mText = text;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getAuthorID() {
        return mAuthorID;
    }
    public void setAuthorID(int authorID) {
        mAuthorID = authorID;
    }
}
