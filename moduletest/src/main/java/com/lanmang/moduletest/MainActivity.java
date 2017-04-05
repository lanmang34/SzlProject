package com.lanmang.moduletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lanmang.modulelib.util.TestUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text1 = (TextView) findViewById(R.id.text1);
        text1.setText(com.lanmang.modulea.util.TestUtil.getModuleA());

        TextView text2 = (TextView) findViewById(R.id.text2);
        text2.setText(com.lanmang.moduleb.util.TestUtil.getModuleB());

        TextView text3 = (TextView) findViewById(R.id.text3);
        text3.setText(TestUtil.getModuleLib());
    }
}
