package com.example.sbt_markin_aa.trelolo.presenter;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.sbt_markin_aa.trelolo.R;
import com.example.sbt_markin_aa.trelolo.views.fragments.LoginPageFragment;

/**
 * Created by sbt-markin-aa on 20.04.17.
 */

public class LoginPageActivityPresenter {

    public void createFragment(Fragment mFragment, AppCompatActivity activity){
        if (mFragment==null){
            mFragment = new LoginPageFragment();
        }

        activity.getSupportFragmentManager().beginTransaction().add(R.id.container_for_page_activity_fragment,mFragment).commit();
    }
}
