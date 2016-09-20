package com.szl.test.test.mvp;

/**
 * Created by songziliang on 2016/9/18.
 */
public abstract class PhoneContract {
    public interface PhonePresenter{
        void addPhone();
    }

    public interface PhoneView{
        void showPhone();
    }
}
