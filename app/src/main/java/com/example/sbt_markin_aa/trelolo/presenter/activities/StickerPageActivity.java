package com.example.sbt_markin_aa.trelolo.presenter.activities;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sbt_markin_aa.trelolo.R;
import com.example.sbt_markin_aa.trelolo.model.data_bindings.StickerDataBinding;
import com.example.sbt_markin_aa.trelolo.model.instances.Sticker;
import com.example.sbt_markin_aa.trelolo.presenter.fragments.LoginPageFragment;
import com.example.sbt_markin_aa.trelolo.presenter.fragments.StickerPageFragment;

import java.util.List;

public class StickerPageActivity extends FragmentActivity {
    private StickerPageFragment mFragment;
    private ViewPager mViewPager;
    private List<Sticker> mStickers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sticker_page_activity);

        Intent intent = getIntent();

        mViewPager = (ViewPager) findViewById(R.id.sticker_page_activity_view_page);
        mStickers = StickerDataBinding.getStickers(intent.getIntExtra(LoginPageFragment.PERSON_ID,0),this);

        if(mFragment==null){
            mFragment = new StickerPageFragment();
        }
        //getSupportFragmentManager().beginTransaction().add(R.id.container_for_sticker_page_activity_fragment,mFragment).commit();
    }
}
