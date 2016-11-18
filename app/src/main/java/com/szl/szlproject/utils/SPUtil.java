package com.szl.szlproject.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.szl.szlproject.base.BaseApplication;


/**
 * Created by songziliang on 2016/9/1.
 * SharedPreferences 存储工具类
 */
public class SPUtil {
    private static SharedPreferences mPrefs;
    private static String defaultFileName = "config";

    private static Context getContext() {
        return BaseApplication.getContext();
    }

    public static void put(String key, Object value) {
        put(key, value, null);
    }
    public static void put(String key, Object value, String newFileName){
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);

        if(value == null){
            remove(key, newFileName);
            return;
        }

        if (value instanceof Boolean) {
            mPrefs.edit().putBoolean(key, (Boolean) value).apply();
        } else if (value instanceof Integer) {
            mPrefs.edit().putInt(key, (Integer) value).apply();
        } else if (value instanceof Long) {
            mPrefs.edit().putLong(key, (Long) value).apply();
        } else if (value instanceof String) {
            mPrefs.edit().putString(key, (String) value).apply();
        }
    }

    public static Long getLong(String key, long value) {
        return getLong(key, value, null);
    }
    public static Long getLong(String key,long value, String newFileName){
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        return mPrefs.getLong(key, value);
    }

    public static float getFloat(String key, long value) {
        return getFloat(key, value, null);
    }
    public static float getFloat(String key,long value, String newFileName){
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        return mPrefs.getFloat(key, value);
    }

    public static boolean getBoolean(String key, boolean value) {
        return getBoolean(key, value, null);
    }
    public static boolean getBoolean(String key,boolean value, String newFileName){
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        return mPrefs.getBoolean(key, value);
    }

    public static String getString(String key, String value) {
        return getString(key, value, null);
    }
    public static String getString(String key,String value, String newFileName){
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        return mPrefs.getString(key, value);
    }

    public static Integer getInt(String key, int value) {
        return getInt(key, value, null);
    }
    public static Integer getInt(String key,int value, String newFileName){
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        return mPrefs.getInt(key, value);
    }

    public static void remove(String name) {
        remove(name, null);
    }
    public static void remove(String name, String newFileName) {
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        mPrefs.edit().remove(name).apply();
    }

}
