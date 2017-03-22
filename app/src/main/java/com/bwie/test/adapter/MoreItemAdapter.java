package com.bwie.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.test.MoreItemActivity;
import com.bwie.test.R;
import com.bwie.test.holder.RfirstTypeViewHolder;
import com.bwie.test.holder.RsecondTypeViewHolder;
import com.bwie.test.holder.RthirdTypeViewHolder;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/21 20:28
 */

public class MoreItemAdapter extends RecyclerView.Adapter {
    private final Context context;
    private static final int FIRST_TYPE=0;
    private static final int SECOND_TYPE=1;
    private static final int THIRD_TYPE=2;
    private String cool;
    private int type=FIRST_TYPE;
    public MoreItemAdapter(Context context, String cool) {
        this.context=context;
        this.cool=cool;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        switch (viewType){
            case 0:
                View view= LayoutInflater.from(context).inflate(R.layout.first_type,parent,false);
                viewHolder=new RfirstTypeViewHolder(view);
                break;
            case 1:
                View view1= LayoutInflater.from(context).inflate(R.layout.second_type,parent,false);
                viewHolder=new RsecondTypeViewHolder(view1);
                break;
            case 2:
                View view2= LayoutInflater.from(context).inflate(R.layout.third_type,parent,false);
                viewHolder=new RthirdTypeViewHolder(view2);
                break;
        }
        return viewHolder;
    }
    //设置数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //获取条目类型
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
                break;
            case 1:
                RsecondTypeViewHolder viewHolder= (RsecondTypeViewHolder) holder;
                viewHolder.text.setText(cool);
                break;
            case 2:
                break;
        }
    }
    //判断当前条目类型
    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                type=FIRST_TYPE;
                break;
            case 1:
                type=SECOND_TYPE;
                break;
            case 2:
                type=THIRD_TYPE;
                break;
        }
        return type;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
