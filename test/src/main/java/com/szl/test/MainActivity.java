package com.szl.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.szl.test.base.BaseActivity;
import com.szl.test.common.Constants;
import com.szl.test.service.TestServiceActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    /**
     * 添加练习页
     */
    private void loadData() {
        add("练习Service", TestServiceActivity.class);
    }

    //View.
    private ListView lv_test;

    //Data.
    private List<Bean> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_test = (ListView)findViewById(R.id.lv_test);

        //load data.
        loadData();

        TestAdapter adapter = new TestAdapter();
        lv_test.setAdapter(adapter);
    }

    @Override
    public void setTitle(TextView tv_title) {
        tv_title.setText("练习用app");
    }

    private void add(String name, Class aClass) {
        mDatas.add(new Bean(name, aClass));
    }

    private class TestAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(MainActivity.this, R.layout.item_test, null);
                convertView.setTag(holder);
                holder.btn_test = (Button) convertView.findViewById(R.id.btn_test);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            final Bean bean = mDatas.get(position);
            holder.btn_test.setText(bean.getName());
            holder.btn_test.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, bean.getaClass());
                    intent.putExtra(Constants.TITLE, bean.getName());
                    startActivity(intent);
                }
            });

            return convertView;
        }

        class ViewHolder {
            Button btn_test;
        }
    }

    class Bean {
        private String name;
        private Class aClass;

        public Bean(String name, Class aClass) {
            this.name = name;
            this.aClass = aClass;
        }

        public String getName() {
            return name;
        }

        public Class getaClass() {
            return aClass;
        }
    }
}
