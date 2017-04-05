package com.szl.test.test.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.szl.test.R;

import java.util.List;

/**
 * Created by lanmang on 2017/3/20.
 */

class TestAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<String> mDatas;

    public TestAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> datas) {
        mDatas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(View.inflate(context, R.layout.item_recycler, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder h = (Holder) holder;
        h.text.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView text;

        public Holder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
