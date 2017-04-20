package com.example.sbt_markin_aa.trelolo.views.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.sbt_markin_aa.trelolo.R;
import com.example.sbt_markin_aa.trelolo.model.data_bindings.BoardDataBinding;
import com.example.sbt_markin_aa.trelolo.model.instances.Board;
import com.example.sbt_markin_aa.trelolo.presenter.StickerPageActivityPresenter;
import com.example.sbt_markin_aa.trelolo.views.fragments.LoginPageFragment;
import com.example.sbt_markin_aa.trelolo.views.fragments.StickerPageFragment;

import java.util.List;

public class StickerPageActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private StickerPageActivityPresenter mPresenter;

    public StickerPageActivity(){
        mPresenter = new StickerPageActivityPresenter();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sticker_page_activity);
        Intent intent = getIntent();

        mPresenter.setPersonId(intent);

        mViewPager = (ViewPager) findViewById(R.id.sticker_page_activity_view_page);

        mPresenter.setBoards(getApplicationContext());

        FragmentManager fragmentManager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return StickerPageFragment.newInstance(mPresenter.getPersonId(), position);
            }

            @Override
            public int getCount() {
                return mPresenter.getBoardSize();
            }
        });

        //getSupportFragmentManager().beginTransaction().add(R.id.container_for_sticker_page_activity_fragment,mFragment).commit();
    }
}
