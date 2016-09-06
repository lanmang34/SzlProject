package com.szl.szlproject.ui;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.szl.szlibrary.base.SzlActivity;
import com.szl.szlproject.R;

public class MainActivity extends SzlActivity {

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

        }
        super.onDestroy();
    }
}
