package com.lanmang.modulea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lanmang.modulelib.util.TestUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text3 = (TextView) findViewById(R.id.text3);
        text3.setText(TestUtil.getModuleLib());
    }
}
