package com.szl.szlproject.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

import com.szl.szlproject.base.BaseApplication;


/**
 * Created by songziliang on 2016/9/1.
 * 网络工具类
 */
public class NetworkUtil {

    private static Context getContext(){
        return BaseApplication.getContext();
    }

    /*
    判断网络是否可用,false为不可用,true为可用
     */
    public static boolean hasNetwork(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager != null){
            NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();
            for(NetworkInfo info : networkInfos ){
                if(info.getState() == State.CONNECTED){
                    return true;
                }
            }
        }
        return false;
    }
}
