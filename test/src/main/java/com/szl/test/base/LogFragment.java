package com.szl.test.base;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by songziliang on 2016/9/20.
 */
public class LogFragment extends BaseFragment {
    public void setLog(String log) {
        Activity activity = getActivity();
        if (activity instanceof LogActivity) {
            LogActivity logActivity = (LogActivity) activity;
            logActivity.setLog(log);
        }else{
            Toast.makeText(getActivity(), "不是LogActivity，不能生成log", Toast.LENGTH_SHORT).show();
        }
    }
}
