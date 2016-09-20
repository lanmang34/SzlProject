package com.szl.test.test.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.szl.test.R;
import com.szl.test.base.LogActivity;

public class TestServiceActivity extends LogActivity {

    //View.

    //Data.
    private Intent mServiceIntent;
    private ServiceConnection mConn;
    private IService mIService;
    private boolean mBindSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_service);
        mServiceIntent = new Intent(this, TestService.class);
        mConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                setLog("activity bind service success");
                mBindSuccess = true;
                mIService = (IService) service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                setLog("activity bind service fail");
                mBindSuccess = false;
            }
        };
    }

    public void startService(View v) {
        startService(mServiceIntent);
        setLog("activity start service");
    }

    public void stopService(View v) {
        stopService(mServiceIntent);
        setLog("activity stop service");
    }

    public void bindService(View v) {
        bindService(mServiceIntent, mConn, BIND_AUTO_CREATE);
        setLog("activity bind service");
    }

    public void unBindService(View v) {
        unBind();
    }

    private void unBind() {
        if (mBindSuccess) {
            mBindSuccess = false;
            unbindService(mConn);
            setLog("activity unBind service");
        } else{
            setLog("activity 未绑定服务 不能解绑");
        }
    }

    public void callMethodInService(View v) {
        if (mBindSuccess) {
            mIService.sayHello();
            setLog("activity 绑定service后, 调用service中的方法");
        }else{
            setLog("activity 未绑定service 不能调用service中的方法");
        }
    }

    @Override
    protected void onDestroy() {
        unBind();
        super.onDestroy();
    }
}
