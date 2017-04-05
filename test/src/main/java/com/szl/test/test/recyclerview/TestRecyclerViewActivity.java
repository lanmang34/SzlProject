package com.szl.test.test.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.szl.test.R;
import com.szl.test.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class TestRecyclerViewActivity extends BaseActivity {

    private RecyclerView recycler_view;
    private List<String> datas;
    private TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recycler_view);
        recycler_view = (RecyclerView)findViewById(R.id.recycler_view);
        adapter = new TestAdapter(this);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(adapter);
        datas = getData();
        adapter.setData(datas);
        adapter.notifyDataSetChanged();
    }

    public void loadData(View v) {
        datas.remove(0);
        adapter.notifyDataSetChanged();
    }

    public void refresh(View v) {
        datas.add("新数据" + datas.size());
        adapter.notifyItemChanged(datas.size() - 1);
    }

    public List<String> getData() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("原始数据" + i);
        }
        return strings;
    }
}
