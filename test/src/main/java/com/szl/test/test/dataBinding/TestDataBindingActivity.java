package com.szl.test.test.dataBinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.szl.test.R;
import com.szl.test.base.BaseActivity;

public class TestDataBindingActivity extends BaseActivity {

    private com.szl.test.test.dataBinding.TestDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = View.inflate(this, R.layout.activity_test_data_binding, null);
        setContentView(root);
        binding = DataBindingUtil.bind(root);
        testDataBinding();
    }

    private void testDataBinding() {
        binding.textview.setText("lalala");
        binding.ivImageview.setImageResource(R.mipmap.ic_launcher);
    }
}
