package com.szl.test.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by lanmang on 2016/12/5.
 */

public class AppUtil {
    /**
     * 判断摄像头是否存在
     * @param context
     * @return
     */
    public static boolean checkCaremaHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;//摄像头存在
        }else{
            return false;//摄像头不存在
        }
    }
}
