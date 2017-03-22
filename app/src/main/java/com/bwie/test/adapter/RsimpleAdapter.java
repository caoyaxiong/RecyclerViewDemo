package com.bwie.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.test.R;
import com.bwie.test.SimpleActivity;
import com.bwie.test.holder.RsimpleHolder;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/21 13:40
 */

public class RsimpleAdapter extends RecyclerView.Adapter<RsimpleHolder> {

    private final Context context;
    private final List<String> list;

    public RsimpleAdapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
    }
    //关联相应的viewHolder
    @Override
    public RsimpleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        RsimpleHolder rsimpleHolder=new RsimpleHolder(view);
        return rsimpleHolder;
    }
    //设置每个条目的数据
    @Override
    public void onBindViewHolder(RsimpleHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }
    //
    @Override
    public int getItemCount() {
        return list.size();
    }
}
