package com.szl.test.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.szl.test.R;
import com.szl.test.base.LogActivity;

public class T1Activity extends LogActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t1);
    }

    @Override
    protected void onStop() {
        super.onStop();
        TestDialog.release();
    }

    public void startDialog(View v) {

        TestDialog.showDialog(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(T1Activity.this, T2Activity.class));
            }
        },2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TestDialog.release();
            }
        }, 5000);
    }

    public void start2(View v) {
        startActivity(new Intent(T1Activity.this, T2Activity.class));
    }

}
