package com.bwie.test;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.bwie.test.adapter.WaterWallAdapter;

import java.util.ArrayList;
import java.util.List;

public class RefreshActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swpeRefershLayout;
    private List<String> list;
    private WaterWallAdapter adapter;
    Handler handler=new Handler(){};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        swpeRefershLayout = (SwipeRefreshLayout) findViewById(R.id.swpeRefershLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        initData();
        adapter = new WaterWallAdapter(this,list);
        recyclerView.setAdapter(adapter);
        swpeRefershLayout.setColorSchemeColors(Color.BLUE,Color.RED,Color.GREEN);
        swpeRefershLayout.setOnRefreshListener(this);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("直到没朋友。。。"+i);
        }
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                list.add(0,"最新。。。。");
                adapter.notifyDataSetChanged();
                swpeRefershLayout.setRefreshing(false);
            }
        },2000);
    }
}
