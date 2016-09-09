package com.szl.test.base;

import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.szl.test.R;
import com.szl.test.common.Constants;

/**
 * Created by songziliang on 2016/9/8.
 */
public abstract class LogActivity extends BaseActivity {

    //view.
    private TextView tv_log;
    private ScrollView sv_log;
    private LinearLayout ll_log;

    //data.
    private static Handler mHandler = new Handler();

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.base_log);

        //初始化默认布局
        initDefaultView(layoutResID);
    }

    @Override
    public void setTitle(TextView tv_title) {
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra(Constants.TITLE);
            tv_title.setText(title);
        }else{
            tv_title.setText("练习用app");
        }
    }

    /**
     * 初始化默认布局
     * @param layoutResID
     */
    private void initDefaultView(int layoutResID) {
        ll_log = (LinearLayout) findViewById(R.id.ll_log);
        sv_log = (ScrollView) findViewById(R.id.sv_log);
        tv_log = (TextView)findViewById(R.id.tv_log);
        ScrollView sv_container = (ScrollView) findViewById(R.id.sv_container);
        View childeView = LayoutInflater.from(this).inflate(layoutResID, null);
        sv_container.addView(childeView, 0);
    }

    public void setLog(String log) {
        tv_log.append("\n" + log);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                scroll2Bottom(sv_log, tv_log);
            }
        }, 10);

    }

    public void clearLog() {
        tv_log.setText("");
    }

    public void hideLog() {
        ll_log.setVisibility(View.GONE);
    }

    public void showLog() {
        ll_log.setVisibility(View.VISIBLE);
    }


    public static void scroll2Bottom(final ScrollView scroll, final View inner) {
                if (scroll == null || inner == null) {
                    return;
                }
                // 内层高度超过外层
                int offset = inner.getMeasuredHeight()
                        - scroll.getMeasuredHeight();
                if (offset < 0) {
                    offset = 0;
                }
                scroll.scrollTo(0, offset);
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
