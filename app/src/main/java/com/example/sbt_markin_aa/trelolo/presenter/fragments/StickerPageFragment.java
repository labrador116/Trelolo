package com.example.sbt_markin_aa.trelolo.presenter.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.sbt_markin_aa.trelolo.model.instances.Sticker;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sbt-markin-aa on 17.04.17.
 */

public class StickerPageFragment extends Fragment {
    public static final String ARG_STICKERS_LIST_ID = "stickers_list";

    private int mPersonId;
    private int mPosition;


    public static StickerPageFragment newInstance(int personId, int position){
        Bundle args = new Bundle();
        args.putInt(LoginPageFragment.PERSON_ID, personId);
        args.putInt(ARG_STICKERS_LIST_ID, position);
        StickerPageFragment fragment = new StickerPageFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPersonId = savedInstanceState.getInt(LoginPageFragment.PERSON_ID);
        mPosition = savedInstanceState.getInt(ARG_STICKERS_LIST_ID);
    }
}
