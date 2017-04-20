package com.example.sbt_markin_aa.trelolo.views.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.sbt_markin_aa.trelolo.R;
import com.example.sbt_markin_aa.trelolo.presenter.LoginPageActivityPresenter;
import com.example.sbt_markin_aa.trelolo.views.fragments.LoginPageFragment;

/**
 * Created by sbt-markin-aa on 13.04.17.
 */

public class LoginPageActivity extends AppCompatActivity {
    private LoginPageFragment mFragment;
    private LoginPageActivityPresenter mPresenter;

    public LoginPageActivity(){
        mPresenter = new LoginPageActivityPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page_activity);

        mPresenter.createFragment(mFragment,this);
    }
}
