package com.vinayak.blooddonner;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    private final String INTRO = "intro";
    private final String NAME = "name";
    private final String EMAIL = "email";
    private final String MOBILE = "mobile";
    private final String ADDRESS = "address";

    private SharedPreferences app_prefs;
    private Context context;

    public PreferenceHelper(Context context) {
        app_prefs = context.getSharedPreferences("shared", Context.MODE_PRIVATE);
        this.context = context;
    }

    public void putIsLogin(boolean loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putBoolean(INTRO, loginorout);
        edit.commit();
    }
    public boolean getIsLogin() {
        return app_prefs.getBoolean(INTRO, false);
    }


//     For Name
    public void putName(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(NAME, loginorout);
        edit.commit();
    }
    public String getName() {
        return app_prefs.getString(NAME, "");
    }


    public void putEmail(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(EMAIL, loginorout);
        edit.commit();
    }
    public String getEmail() {
        return app_prefs.getString(EMAIL, "");
    }

//    For Mobile
    public void putMobile(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(MOBILE, loginorout);
        edit.commit();
    }
    public String getMobile() { return app_prefs.getString(MOBILE, ""); }

//    For Address
    public void putAddress(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(ADDRESS, loginorout);
        edit.commit();
    }
    public String getAddress() {
        return app_prefs.getString(ADDRESS, "");
    }

}
