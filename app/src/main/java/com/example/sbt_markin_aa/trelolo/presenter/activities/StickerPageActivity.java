package com.example.sbt_markin_aa.trelolo.presenter.activities;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sbt_markin_aa.trelolo.R;
import com.example.sbt_markin_aa.trelolo.presenter.fragments.StickerPageFragment;

public class StickerPageActivity extends FragmentActivity {
    private StickerPageFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sticker_page_activity);

        if(mFragment==null){
            mFragment = new StickerPageFragment();
        }
        getSupportFragmentManager().beginTransaction().add(R.id.container_for_sticker_page_activity_fragment,mFragment).commit();
    }
}
