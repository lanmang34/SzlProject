package com.szl.szlproject.ui;

import android.os.Bundle;
import android.view.KeyEvent;

import com.szl.szlproject.R;
import com.szl.szlproject.base.BaseActivity;

public class GuideActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;//禁止引导页退出
        }
        return super.onKeyDown(keyCode, event);
    }
}
