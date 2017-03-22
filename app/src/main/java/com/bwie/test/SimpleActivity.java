package com.bwie.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwie.test.adapter.RsimpleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/21 13:23
 */

public class SimpleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> list;
    private RsimpleAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_item);
        //找控件
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //添加数据
        initData();
        //设置布局管理者，展示数据
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //适配数据
        adapter = new RsimpleAdapter(this,list);
        //添加下划线
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
       
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("RecyclerView"+i);
        }
    }

    public void moreHorizontal(View view) {
       recyclerView.setLayoutManager(new GridLayoutManager(this,5,LinearLayoutManager.HORIZONTAL,false));
        adapter.notifyDataSetChanged();
    }

    public void singleHorizontal(View view) {
       recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapter.notifyDataSetChanged();
    }

    public void moreLine(View view) {
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        adapter.notifyDataSetChanged();
    }

    public void singleLine(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
    }
}
