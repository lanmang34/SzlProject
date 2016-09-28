package com.szl.test.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;

import com.szl.test.R;
import com.szl.test.base.BaseApplication;

/**
 * Created by songziliang on 2016/9/23.
 */
public class DialogUtil {

    //view.
    private static AlertDialog m1PxDialog;

    private static Context getContext() {
        return BaseApplication.getContext();
    }

    /**
     * 显示 1像素 dialog
     */
    public static void show1PxDialog(Activity activity) {
        View inflate = View.inflate(getContext(), R.layout.dialog_1px, null);
        if (m1PxDialog != null) {
            if (!m1PxDialog.isShowing()) {
                m1PxDialog.show();
            }
            return;
        }
        View view = new View(getContext());
        view.setLayoutParams(new LayoutParams(1, 1));
        view.setAlpha(0);
        m1PxDialog = new Builder(activity)
                .setView(inflate)
                .show();
        m1PxDialog.setCanceledOnTouchOutside(false);
        Window window = m1PxDialog.getWindow();
        window.setDimAmount(0);//取消边上的灰色
        window.setBackgroundDrawableResource(R.drawable.dialog_transparent);
    }

    /**
     * 销毁 1像素 dialog
     */
    public static void hide1PxDialog() {
        if (m1PxDialog != null) {
            if (m1PxDialog.isShowing()) {
                m1PxDialog.dismiss();
            }
            m1PxDialog = null;
        }
    }
}
