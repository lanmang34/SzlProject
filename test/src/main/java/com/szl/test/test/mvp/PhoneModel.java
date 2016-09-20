package com.szl.test.test.mvp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songziliang on 2016/9/18.
 */
public class PhoneModel {

    //data.
    public List<String> mDatas = new ArrayList<>();
    private int i = 0;

    public void addPhone() {
        mDatas.add("手機" + ++i);
    }
}
