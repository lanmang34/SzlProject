package com.szl.test.test.toast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.szl.test.R;
import com.szl.test.base.BaseActivity;

/**
 * Created by lanmang on 2016/12/12.
 */

public class TestToastActivity extends BaseActivity {

    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toast);
    }

    public void toast1(View v) {
        //Toast.makeText(this, "我是toast1", Toast.LENGTH_SHORT).show();
        Toast toast = new Toast(this);
        View inflate = View.inflate(this, R.layout.my_toast, null);
        TextView tv_message = (TextView) inflate.findViewById(R.id.tv_message);
        tv_message.setText("toast1");
        toast.setView(inflate);
        toast.show();
    }

    public void toast2(View v) {
        MyToast.getInstance().makeText(this, "我是MyToast" + ++i, 10000).show();
    }

    public void toast3(View v) {
        Toast toast = new Toast(this);
        View inflate = View.inflate(this, R.layout.my_toast3, null);
        TextView tv_message = (TextView) inflate.findViewById(R.id.tv_message);
        tv_message.setText("toast3");
        toast.setView(inflate);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void toast4(View v) {
        ToastHelper.errorToast(this, "我是错误信息啦啦啦");
    }

    public void toast5(View v) {
        ToastHelper.registerSuccess(this);
    }
}
