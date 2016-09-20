package com.szl.test.test.mvp;

import com.szl.test.test.mvp.PhoneContract.PhoneView;

/**
 * Created by songziliang on 2016/9/18.
 */
public class PhonePresenter implements PhoneContract.PhonePresenter {

    private PhoneModel mPhoneModel;
    private PhoneView mPhoneView;

    public PhonePresenter(PhoneView mPhoneView, PhoneModel phoneModel) {
        this.mPhoneModel = phoneModel;
        this.mPhoneView = mPhoneView;
    }

    @Override
    public void addPhone() {
        mPhoneModel.addPhone();
        mPhoneView.showPhone();
    }
}
