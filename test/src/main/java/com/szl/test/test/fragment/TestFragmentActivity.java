package com.szl.test.test.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.szl.test.R;
import com.szl.test.base.LogActivity;

public class TestFragmentActivity extends LogActivity {

    //view.
    private TextView tv_no_fragment;

    //data.
    private Fragment fragment1;
    private Fragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        setLog("TestFragmentActivity onCreate");
        tv_no_fragment = (TextView) findViewById(R.id.tv_no_fragment);
        fragment1 = new TestFragment1();
        fragment2 = new TestFragment2();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setLog("TestFragmentActivity onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        setLog("TestFragmentActivity onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setLog("TestFragmentActivity onRestart");
    }

    public void replace1(View v) {
        setLog("TestFragmentActivity btn replace fragment1");
        replaceFragment(fragment1);
    }

    public void replace2(View v) {
        setLog("TestFragmentActivity btn replace fragment2");
        replaceFragment(fragment2);
    }

    public void startSecond(View v) {
        setLog("TestFragmentActivity btn startSecondActivity");
        startActivity(new Intent(this, SecondActivity.class));
    }

    private void replaceFragment(Fragment fragment) {
        if (tv_no_fragment.isShown()) {
            tv_no_fragment.setVisibility(View.GONE);
        }
        getFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        setLog("TestFragmentActivity onWindowFocusChanged");
    }

    @Override
    protected void onPause() {
        super.onPause();
        setLog("TestFragmentActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        setLog("TestFragmentActivity onStop");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        setLog("TestFragmentActivity onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setLog("TestFragmentActivity onDestroy");
    }
}
