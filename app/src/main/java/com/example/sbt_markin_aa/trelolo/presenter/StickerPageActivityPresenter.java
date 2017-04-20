package com.example.sbt_markin_aa.trelolo.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.sbt_markin_aa.trelolo.model.data_bindings.BoardDataBinding;
import com.example.sbt_markin_aa.trelolo.model.instances.Board;
import com.example.sbt_markin_aa.trelolo.views.fragments.LoginPageFragment;

import java.util.List;

/**
 * Created by sbt-markin-aa on 20.04.17.
 */

public class StickerPageActivityPresenter {
    private int mPersonId;
    private List<Board> mBoards;

    public void setPersonId(Intent intent){
        mPersonId = intent.getIntExtra(LoginPageFragment.PERSON_ID,0);
    }

    public int getPersonId(){
        return mPersonId;
    }

    public void setBoards (Context context){
        mBoards = BoardDataBinding.getAllBoardsForPerson(mPersonId, context);
    }

    public int getBoardSize(){
        return mBoards.size();
    }



}
