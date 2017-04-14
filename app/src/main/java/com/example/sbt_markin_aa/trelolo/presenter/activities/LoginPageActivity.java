package com.example.sbt_markin_aa.trelolo.presenter.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.sbt_markin_aa.trelolo.R;
import com.example.sbt_markin_aa.trelolo.presenter.fragments.LoginPageFragment;

/**
 * Created by sbt-markin-aa on 13.04.17.
 */

public class LoginPageActivity extends AppCompatActivity {
    private LoginPageFragment mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page_activity);

        if (mFragment==null){
            mFragment = new LoginPageFragment();
        }

        getSupportFragmentManager().beginTransaction().add(R.id.container_for_page_activity_fragment,mFragment).commit();
    }
}
