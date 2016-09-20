package com.szl.test.test.mvp;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.szl.test.R;
import com.szl.test.base.LogActivity;
import com.szl.test.test.mvp.PhoneContract.PhoneView;
import com.szl.test.widget.ScrollListView;

/**
 * Created by songziliang on 2016/9/18.
 */
public class TestMVPActivity extends LogActivity implements PhoneView, OnClickListener {

    //view.
    private Button btn_create_phone;
    private ScrollListView lv_phone;

    //data.
    private PhonePresenter mPhonePresenter;
    private PhoneAdapter phoneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mvp);
        initView();
        setListener();
        setData();
    }

    private void setData() {
        PhoneModel phoneModel = new PhoneModel();
        mPhonePresenter = new PhonePresenter(this, phoneModel);
        phoneAdapter = new PhoneAdapter(this, phoneModel.mDatas);
        lv_phone.setAdapter(phoneAdapter);
    }

    private void initView() {
        btn_create_phone = (Button) findViewById(R.id.btn_create_phone);
        lv_phone = (ScrollListView)findViewById(R.id.lv_phone);
    }

    private void setListener() {
        btn_create_phone.setOnClickListener(this);
    }

    @Override
    public void showPhone() {
        phoneAdapter.notifyDataSetChanged();
        setLog("創建手機");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create_phone :
                mPhonePresenter.addPhone();
                break;
        }
    }
}
