package com.szl.test.test.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.szl.test.R;
import com.szl.test.base.BaseActivity;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.e("TAG", "SecondActivity onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("TAG", "SecondActivity onReStart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG", "SecondActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "SecondActivity onResume");
    }

    @Override
    public void setTitle(TextView tv_title) {
        tv_title.setText("用来覆盖TestFragmentActivity以测试fragment生命周期");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG", "SecondActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "SecondActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "SecondActivity onDestroy");
    }
}
