package com.qboxus.android.ApiClasses;

import android.content.Context;
import android.content.SharedPreferences;

public class SdkInit {

    Context context;
  public SdkInit (Context context){
      this.context=context;
  }

  public void initialize() {
      SharedPreferences sharedPreferences =context.getSharedPreferences("MyPref",Context.MODE_PRIVATE);
      sharedPreferences.edit().putBoolean("islogin",false).commit();
  }
}
