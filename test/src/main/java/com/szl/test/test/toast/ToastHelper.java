package com.szl.test.test.toast;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.szl.test.R;

/**
 * Created by lanmang on 2016/12/14.
 */

public class ToastHelper {

    public final static int TOAST_TYPE_ERROR = 1;
    public final static int TOAST_TYPE_REGISTER_SUCCESS = 2;

    public static void errorToast(Context context, String content) {
        showToast(context, content, TOAST_TYPE_ERROR);
    }

    public static void registerSuccess(Context context) {
        showToast(context, "恭喜您注册成功!", TOAST_TYPE_REGISTER_SUCCESS);
    }

    private static void showToast(Context context, String content, int type) {
        View inflate = View.inflate(context, R.layout.toast_helper, null);
        TextView tv_error_dialog = (TextView) inflate.findViewById(R.id.tv_message);
        ImageView iv_message_icon = (ImageView) inflate.findViewById(R.id.iv_icon);
        tv_error_dialog.setText(content);

        Toast toast = new Toast(context);
        toast.setMargin(0, 0);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(inflate);

        switch (type) {
            case TOAST_TYPE_ERROR :
                iv_message_icon.setVisibility(View.GONE);
                break;
            case TOAST_TYPE_REGISTER_SUCCESS :
                iv_message_icon.setVisibility(View.VISIBLE);
                break;
        }

        toast.show();

    }
}
