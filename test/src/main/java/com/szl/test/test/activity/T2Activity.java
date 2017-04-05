package com.szl.test.test.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.szl.test.R;
import com.szl.test.base.LogActivity;

public class T2Activity extends LogActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t2);
    }

    public void showDialog(View v) {
        TestDialog.showDialog(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },2000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        TestDialog.release();
    }
}
