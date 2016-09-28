package com.szl.test.test.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.szl.test.R;
import com.szl.test.base.LogActivity;
import com.szl.test.utils.DialogUtil;

public class TestDialogActivity extends LogActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dialog);
    }

    public void showdialog(View v) {
        setLog("显示 1px dialog 屏幕不能点击 点击右下角back按钮dismiss dialog");
        DialogUtil.show1PxDialog(this);
    }

    public void hidedialog(View v) {
        setLog("隐藏 1px dialog");
        DialogUtil.hide1PxDialog();
    }

    public void toast(View v) {
        setLog("可以点击");
        Toast.makeText(this, "可以点击", Toast.LENGTH_SHORT).show();
    }
}
