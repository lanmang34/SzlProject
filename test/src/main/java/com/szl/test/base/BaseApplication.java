package com.szl.test.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by songziliang on 2016/9/23.
 */
public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
