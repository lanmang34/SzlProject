package com.szl.szlibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.widget.Toast;

import com.szl.szlibrary.base.SzlApplication;

/**
 * Created by songziliang on 2016/9/1.
 */
public class PhoneUtil {

    private static Context getContext() {
        return SzlApplication.getContext();
    }

    /**
     * 拨打电话
     * 显示拨号键盘，不直接拨打
     */
    public static boolean dialPhone(Context context, String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        ResolveInfo resolveInfo = getContext().getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfo == null) {
            Toast.makeText(getContext(), "未安装电话应用", Toast.LENGTH_SHORT).show();
            return false;
        }

        context.startActivity(intent);
        return true;
    }

}
