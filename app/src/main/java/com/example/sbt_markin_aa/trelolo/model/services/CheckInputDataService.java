package com.example.sbt_markin_aa.trelolo.model.services;

import android.content.Context;
import android.widget.Toast;

import com.example.sbt_markin_aa.trelolo.model.data_bindings.CheckFromLoginTableDataBinding;
import com.example.sbt_markin_aa.trelolo.model.database.cursor_wrappers.LoginTableCursorWrapper;

/**
 * Created by sbt-markin-aa on 13.04.17.
 */

public class CheckInputDataService {

    public static void checkData(Context context, String mLogin, String mPassword){
        if(CheckInputDataService.checkInputDataLogin(context,mLogin)){
            if (CheckInputDataService.checkInputPassword(context, mPassword))
            {
                Toast.makeText(context, "Person authorized",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Person isn't authorized",Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(context, "Person isn't authorized",Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean checkInputDataLogin(Context context, String login){
        LoginTableCursorWrapper cursor = CheckFromLoginTableDataBinding.checkPersonLogin(context,login);
        try {
            cursor.moveToFirst();
            return cursor.checkPerson();
        }
        finally {
            cursor.close();
        }
    }
    public static boolean checkInputPassword(Context context, String password){
        LoginTableCursorWrapper cursor = CheckFromLoginTableDataBinding.checkPersonPassword(context,password);
      try {
          cursor.moveToFirst();
          return cursor.checkPerson();
      }
      finally {
          cursor.close();
      }
    }
}
