package com.qboxus.android.ApiClasses;

import android.content.SharedPreferences;
import android.os.Environment;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by AQEEL on 2/15/2019.
 */

public  class Variables {

   public Variables(){}


    public static final String root= Environment.getExternalStorageDirectory().toString();



    public static SharedPreferences sharedPreferences;
    public static final String pref_name="pref_name";
    public static final String u_id="u_id";
    public static final String auth_token ="api_token";

    public static String tag="tictic_";

    // if you want a user can't share a video from your app then you have to set this value to true
    public static final boolean is_secure_info=false;





}
