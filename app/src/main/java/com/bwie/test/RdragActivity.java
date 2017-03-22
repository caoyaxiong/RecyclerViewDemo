package com.bwie.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.bwie.test.adapter.WaterWallAdapter;
import com.bwie.test.callback.ItemTouchCallBack;

import java.util.ArrayList;
import java.util.List;

public class RdragActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> list;
    private WaterWallAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdrag);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initData();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL));
        adapter = new WaterWallAdapter(this, list);
        recyclerView.setAdapter(adapter);
        //设置动画   recyclerView.setItemAnimator()
        //接口回调
        ItemTouchCallBack itemTouchCallBack=new ItemTouchCallBack();
        //设置帮助类
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(itemTouchCallBack);
        //关联recyclerView
        itemTouchHelper.attachToRecyclerView(recyclerView);
        itemTouchCallBack.setAdapter(adapter);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("RecyclerView" + i);
        }
    }
}