package com.szl.test.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * 练习Service
 */
public class TestService extends Service {
    public TestService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new TestBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    private void methodInService(){
        Log.e("TAG", "我是服务里的方法");
        Toast.makeText(getApplicationContext(), "我是服务里的方法", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private class TestBinder extends Binder implements IService{
        @Override
        public void sayHello() {
            methodInService();
        }
    }
}
