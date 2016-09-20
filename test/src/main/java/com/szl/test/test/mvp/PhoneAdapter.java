package com.szl.test.test.mvp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.szl.test.R;

import java.util.List;

/**
 * Created by songziliang on 2016/9/18.
 */
public class PhoneAdapter extends BaseAdapter {

    //data.
    private Context mContext;
    private List<String> mDatas;
    public PhoneAdapter(Context context, List<String> datas) {
        mContext = context;
        mDatas = datas;
    }

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
            convertView = View.inflate(mContext, R.layout.item_mvp, null);
            holder = new ViewHolder();
            holder.content = (TextView) convertView.findViewById(R.id.tv_mvp);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        String str = mDatas.get(position);
        holder.content.setText(str);

        return convertView;
    }

    class ViewHolder{
        TextView content;
    }
}
