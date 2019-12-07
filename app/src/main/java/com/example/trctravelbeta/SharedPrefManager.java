package com.example.trctravelbeta;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    public static final String PREF_NAME = "LOGIN_USER";
    public static final String IS_LOGIN = "IS_LOGIN";
    public static final int ID = 0;

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(String.valueOf(keySP), value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }


    public int getID(){
        return sp.getInt(String.valueOf(ID), 0);
    }



//    public String getUSER_NAME(){
//        return sp.getString(Use, null);
//    }

    public boolean getIS_LOGIN(){
        return sp.getBoolean(IS_LOGIN,false);
    }

    public void logout(){
        spEditor.clear();
        spEditor.commit();
    }

}
