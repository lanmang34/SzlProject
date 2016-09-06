package com.szl.szlibrary.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by songziliang on 2016/9/1.
 */
public class SzlApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
