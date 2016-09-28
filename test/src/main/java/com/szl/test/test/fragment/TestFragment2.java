package com.szl.test.test.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.szl.test.R;
import com.szl.test.base.LogFragment;

/**
 * Created by songziliang on 2026/9/5.
 */
public class TestFragment2 extends LogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setLog("fragment2 onCreateView");
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        setLog("fragment2 onAttach context");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        setLog("fragment2 onAttach activity");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setLog("fragment2 onActivityCreated");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        setLog("fragment2 onHiddenChanged " + hidden);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLog("fragment2 onCreate");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setLog("fragment2 onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        setLog("fragment2 onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        setLog("fragment2 onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        setLog("fragment2 onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        setLog("fragment2 onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        setLog("fragment2 onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        setLog("fragment2 onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        setLog("fragment2 onDetach");
    }
}
