package com.example.sbt_markin_aa.trelolo.presenter.fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sbt_markin_aa.trelolo.R;
import com.example.sbt_markin_aa.trelolo.model.data_bindings.CheckFromLoginTableDataBinding;
import com.example.sbt_markin_aa.trelolo.model.database.data_base_helper.TreloloDBHelper;
import com.example.sbt_markin_aa.trelolo.model.database.schema.TreloloDBSchema;
import com.example.sbt_markin_aa.trelolo.model.services.CheckInputDataService;

/**
 * Created by sbt-markin-aa on 13.04.17.
 */

public class LoginPageFragment extends Fragment
{
    private EditText mLoginEditText;
    private EditText mPasswordEditText;
    private Button mCheckInputDataButton;
    private String mLogin;
    private String mPassword;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_page_fragment,container,false);

        mLoginEditText= (EditText) view.findViewById(R.id.login_editText);
        mPasswordEditText = (EditText) view.findViewById(R.id.password_editText);

        mCheckInputDataButton = (Button) view.findViewById(R.id.check_input_data_button);
        mCheckInputDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLogin=mLoginEditText.getText().toString();
                mPassword = mPasswordEditText.getText().toString();
                CheckInputDataService.checkData(getContext(),mLogin,mPassword);
            }
        });

        return view;
    }



}