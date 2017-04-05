package com.szl.test.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by lanmang on 2016/12/12.
 */

public class PullRefreshListView extends ListView {

    private boolean mPullUpRefreshable;
    private boolean mPullDownRefreshable;

    public PullRefreshListView(Context context) {
        super(context);
    }

    public PullRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullRefreshListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPullUpRefreshable(boolean pullUpRefreshable) {
        mPullUpRefreshable = pullUpRefreshable;
    }

    public void setPullDownRefreshable(boolean pullDownRefreshable) {
        mPullDownRefreshable = pullDownRefreshable;
    }
}
