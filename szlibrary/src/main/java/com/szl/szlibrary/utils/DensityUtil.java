package com.szl.szlibrary.utils;

import android.content.Context;
import com.szl.szlibrary.base.SzlApplication;

/**
 * Created by songziliang on 2016/9/1.
 * dp sp px 转换工具类
 */
public class DensityUtil {

    private static Context getContext() {
        return SzlApplication.getContext();
    }
    
    /**
     * dp转为 px
     */
    public static int dp2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     *  px 转为 dp
     */
    public static int px2dp(float pxValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * 将px值转换为sp值 保证文字大小不变
     */
    public static int px2sp(float pxValue) {
        final float fontScale = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值 保证文字大小不变
     */
    public static int sp2px(float spValue) {
        final float fontScale = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
