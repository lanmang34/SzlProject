package com.szl.test.test.sort;

import android.os.Bundle;

import com.szl.test.R;
import com.szl.test.base.LogActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSortActivity extends LogActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sort);

        setLog("升序：  return lhs.num < rhs.num ? -1 : 1");

        List<Bean> list = new ArrayList<>();
        list.add(new Bean(2));
        list.add(new Bean(4));
        list.add(new Bean(3));
        list.add(new Bean(5));
        list.add(new Bean(6));
        list.add(new Bean(1));
        list.add(new Bean(0));

        Collections.sort(list, new Comparator<Bean>() {
            @Override
            public int compare(Bean lhs, Bean rhs) {
                return lhs.num < rhs.num ? -1 : 1;
            }
        });

        for (Bean bean : list){
            setLog("排序 ： " + bean.num);
        }
    }
    
    class Bean {

        public Bean(int num) {
            this.num = num;
        }

        int num;
    }
}
