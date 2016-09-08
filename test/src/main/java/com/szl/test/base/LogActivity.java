package com.szl.test.base;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.szl.test.R;

/**
 * Created by songziliang on 2016/9/8.
 */
public class LogActivity extends BaseActivity {

    //view.
    private TextView tv_log;

    @Override
    public void setContentView(int layoutResID) {
        View log = View.inflate(this, R.layout.base_log, null);
        super.setContentView(log);

        //初始化默认布局
        initDefaultView(layoutResID);
    }

    /**
     * 初始化默认布局
     * @param layoutResID
     */
    private void initDefaultView(int layoutResID) {
        tv_log = (TextView)findViewById(R.id.tv_log);
        ScrollView sv_container = (ScrollView) findViewById(R.id.sv_container);
        View childeView = LayoutInflater.from(this).inflate(layoutResID, null);
        sv_container.addView(childeView, 0);
    }

    public void setLog(String log) {
        tv_log.append("\n" + log);
    }

    public void clearLog() {
        tv_log.setText("");
    }
}
