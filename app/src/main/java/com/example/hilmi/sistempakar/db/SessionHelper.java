package com.example.hilmi.sistempakar.db;

import android.content.Context;
import android.content.SharedPreferences;



public class SessionHelper {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    static SessionHelper sh;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "SessionApp";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String KEY_APP = "app";
    private static final String KEY_FIRST = "first";

    public static SessionHelper getInstance(Context context){
        if(sh == null){
            sh = new SessionHelper(context);
        }

        return sh;
    }

    public SessionHelper(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setAppFirstTime(boolean status){
        editor.putBoolean(KEY_FIRST, status);

        editor.commit();
    }

    public boolean getAppFirstTime(){
        return pref.getBoolean(KEY_FIRST, true);
    }
}

