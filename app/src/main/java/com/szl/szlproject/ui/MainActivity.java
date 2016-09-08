package com.szl.szlproject.ui;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.szl.szlproject.R;
import com.szl.szlproject.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Handler mHandler = new Handler();
    private boolean back = false;
    @Override
    public void onBackPressed() {
        if (!back) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    back = false;
                }
            }, 2000);
            Toast.makeText(this, "再次点击退出", Toast.LENGTH_SHORT).show();
            back = true;
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
        }
        super.onDestroy();
    }
}
