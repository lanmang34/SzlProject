package com.szl.test.test.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by lanmang on 2017/3/8.
 */

public class TestDialog {

    private static AlertDialog dialog;

    public static void showDialog(Context context) {
        dialog = new AlertDialog.Builder(context)
                .setTitle("测试")
                .setMessage("测试文本")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();

    }

    public static void release() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }
}
