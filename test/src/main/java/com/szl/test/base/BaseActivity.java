package com.szl.test.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.szl.test.R;
import com.szl.test.common.Constants;

/**
 * Created by songziliang on 2016/9/8.
 */
public abstract class BaseActivity extends AppCompatActivity {

    //view.
    private TextView tv_title;
    private FrameLayout fl_container;
    private Toolbar tb_toolbar;

    //data.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //强制竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(R.layout.base_title);
        //初始化默认头部
        initDefaultView(LayoutInflater.from(this).inflate(layoutResID, null));
    }

    /**
     * 初始化默认头部
     */
    private void initDefaultView(View childView) {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tb_toolbar = (Toolbar) findViewById(R.id.tb_toolbar);
        fl_container = (FrameLayout) findViewById(R.id.fl_container);
        fl_container.addView(childView, 0);

        //set data.
        setData();
    }

    private void setData() {
        tb_toolbar.setTitle("");
        setSupportActionBar(tb_toolbar);
        //设置标题
        setTitle(tv_title);
    }

    /**
     * 设置头部
     */
    public void setTitle(TextView tv_title) {
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra(Constants.TITLE);
            if (TextUtils.isEmpty(title)) {
                tv_title.setText("练习用app");
            }else{
                tv_title.setText(title);
            }
        }
    }
}
