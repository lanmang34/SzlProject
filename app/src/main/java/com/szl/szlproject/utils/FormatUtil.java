package com.szl.szlproject.utils;

import java.text.DecimalFormat;

/**
 * Created by songziliang on 2016/9/6.
 * 格式化数据 工具类
 */
public class FormatUtil {
    /**
     * 格式化double，获取2位小数
     * @param num
     * @return
     */
    public static String getDoubleWithTwoDecimals(double num) {
        return getDoubleWithDecimals(num, 2);
    }

    /**
     * 格式化double，获取decimals位小数
     * @param num
     * @param decimals
     * @return
     */
    public static String getDoubleWithDecimals(double num, int decimals) {
        StringBuffer sb = new StringBuffer("#.");
        for(int i = 1; i < decimals; i++) {
          sb.append("#");
        }
        String format = new DecimalFormat(sb.toString()).format(num);
        return format;
    }
}
