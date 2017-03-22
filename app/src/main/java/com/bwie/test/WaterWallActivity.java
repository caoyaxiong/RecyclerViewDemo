package com.bwie.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.bwie.test.adapter.WaterWallAdapter;
import com.bwie.test.listener.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/21 14:14
 */

public class WaterWallActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> list;
    private WaterWallAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waterwall);
        recyclerView = (RecyclerView) findViewById(R.id.waterWall);
        initData();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL));
        adapter = new WaterWallAdapter(this, list);
        adapter.setOnItemClick(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //点击添加
                list.add(position,"新条目");
                adapter.notifyItemInserted(position);
                Toast.makeText(WaterWallActivity.this,"点击了第"+position+"条数据",Toast.LENGTH_SHORT).show();
               
            }

            @Override
            public void onItemLongClick(int position) {
                Toast.makeText(WaterWallActivity.this,"长按了第"+position+"条数据",Toast.LENGTH_SHORT).show();
                //长按删除
                list.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });
        
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("RecyclerView" + i);
        }
    }
}