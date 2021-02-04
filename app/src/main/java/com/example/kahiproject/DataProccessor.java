package com.example.kahiproject;

import android.content.Context;
import android.content.SharedPreferences;

public class DataProccessor {

    private static Context context;

    public DataProccessor(Context context) {
        this.context = context;
    }

    public final static String PREFS_NAME = "appname_prefs";

    public static void setInt(String key, int value) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getInt(String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getInt(key, 0);
    }
    public static void setFloat(String key, float value) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat(key, value);
        editor.apply();
    }
    public static float getFloat (String key)  {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getFloat(key, 0);

    }
    public static void setStr(String key, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStr(String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(key, "DNF");
    }

    public static void setBool(String key, boolean value) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    public static void setLong(String key, long value) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong(key, value);
        editor.apply();
    }
    public static Long getLong(String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getLong(key, 0);
    }
    public static Boolean getBool(String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getBoolean(key, true);
    }
}