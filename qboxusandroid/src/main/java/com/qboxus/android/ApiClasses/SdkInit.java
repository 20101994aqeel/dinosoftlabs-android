package com.qboxus.android.ApiClasses;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SdkInit {

    static {
        System.loadLibrary("qboxusandroid");
    }

  Activity context;
  public SdkInit (Activity context){
      this.context=context;
  }

  public void initialize() {

      // SharedPreferences sharedPreferences =context.getSharedPreferences("MyPref",Context.MODE_PRIVATE);
     // sharedPreferences.edit().putBoolean("islogin",false).commit();

      setStoreBoolValues(context,false);
  }

    public native void setStoreBoolValues(Activity activity, boolean flag);
}
