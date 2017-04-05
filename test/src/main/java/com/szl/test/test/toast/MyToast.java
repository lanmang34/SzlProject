package com.szl.test.test.toast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.szl.test.R;

/**
 * Created by lanmang on 2016/12/13.
 */

public class MyToast {
    private Handler mHandler;
    private final long defaultDuration = 2000;
    private Context mContext;
    private long mDuration;
    private View mView;
    private String mContent;
    private boolean mCancelable; //点击空白处及back按钮是否取消
    private boolean mClickable; //是否允许穿透toast进行点击

    private static MyToast INSTANCE;
    private AlertDialog mAlert;

    public static MyToast getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MyToast();
        }
        return INSTANCE;
    }

    public MyToast makeText(Context context, String content) {
        makeText(context, content, defaultDuration);
        return this;
    }

    public MyToast makeText(Context context, int contentResId) {
        makeText(context, contentResId, defaultDuration);
        return this;
    }

    public MyToast makeText(Context context, int contentResId, long duration) {
        makeText(context, context.getString(contentResId), duration);
        return this;
    }

    public MyToast makeText(Context context, String content, long duration) {
        mContext = context;
        mDuration = duration;
        mContent = content;
        return this;
    }

    public MyToast setView(View view) {
        mView = view;
        return this;
    }

    public MyToast setCancelable(boolean cancelable) {
        mCancelable = cancelable;
        return this;
    }

    public void show() {

        if (mHandler == null) {
            mHandler = new Handler();
        } else {
            mHandler.removeCallbacksAndMessages(null);
        }
        cancel();

        if (mView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(R.layout.my_toast, null);
            TextView tv_message = (TextView) mView.findViewById(R.id.tv_message);
            tv_message.setText(mContent);
        }

        mAlert = new AlertDialog.Builder(mContext)
                .setView(mView)
                .setCancelable(mCancelable)
                .show();
        Window window = mAlert.getWindow();
        if (window != null) {
            window.setDimAmount(0);//取消外围灰色
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        mAlert.show();

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cancel();
            }
        }, mDuration);
    }

    public void cancel() {
        if (mAlert != null) {
            mAlert.dismiss();
            mAlert = null;
        }
        if (mView != null) {
            ViewGroup parent = (ViewGroup) mView.getParent();
            parent.removeAllViews();
            mView = null;
        }
    }
}
