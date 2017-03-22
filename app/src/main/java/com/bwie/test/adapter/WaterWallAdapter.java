package com.bwie.test.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.test.R;
import com.bwie.test.WaterWallActivity;
import com.bwie.test.holder.RsimpleHolder;
import com.bwie.test.listener.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/21 14:20
 */

public class WaterWallAdapter extends RecyclerView.Adapter<RsimpleHolder> {
    private final Context context;
    private final List<String> list;
    private final List<Integer>heightItem;
    private OnRecyclerViewItemClickListener onItemClick;

    public WaterWallAdapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
        //通过随机数定义每个控件的高度
        heightItem=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            heightItem.add((int) (100+200* Math.random()));
        }
    }
    public void setOnItemClick(OnRecyclerViewItemClickListener onItemClick){
        this.onItemClick=onItemClick;
    }
    //关联相应的viewHolder
    @Override
    public RsimpleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        RsimpleHolder rsimpleHolder=new RsimpleHolder(view);
        return rsimpleHolder;
    }
    //设置每个条目的数据和高度
    @Override
    public void onBindViewHolder(RsimpleHolder holder, final int position) {
    //获取textview的布局参数，重新设置高度
        ViewGroup.LayoutParams params=holder.textView.getLayoutParams();
        params.height=heightItem.get(position);
        //设置高度
        holder.textView.setLayoutParams(params);
        holder.textView.setText(list.get(position));
        //设置点击监听
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick != null) {
                    onItemClick.onItemClick(position);
                }
            }
        });
        //设置长按监听
        holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemClick!=null){
                    onItemClick.onItemLongClick(position);
                }
                return true;
            }
        });
               
            
        
        //设置颜色
        holder.textView.setBackgroundColor(Color.rgb((int)(100+155*Math.random()),(int)(100+155*Math.random()),(int)(100+155*Math.random())));
    }
    
    @Override
    public int getItemCount() {
        return list.size();
    }

    public void onMove(int oldPosition, int newPosition) {
    //交换数据
        Collections.swap(list,oldPosition,newPosition);
        //刷新适配器
        this.notifyItemMoved(oldPosition,newPosition);
    }

    public void onDelete(int adapterPosition) {
        list.remove(adapterPosition);
        this.notifyItemRemoved(adapterPosition);
    }
}
