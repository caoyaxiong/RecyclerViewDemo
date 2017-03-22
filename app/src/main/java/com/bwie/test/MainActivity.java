package com.bwie.test;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.AndroidCharacter;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView= (ListView) findViewById(R.id.lv);
        initData();
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list));
        listView.setOnItemClickListener(this);
    }

    private void initData() {
        list = new ArrayList<>();
        list.add("单行  多行  单横  多横");
        list.add("多条目效果展示");
        list.add("瀑布流效果  条目动画");
        list.add("上拉加载  下拉刷新");
        list.add("条目拖动删除效果");
                
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                enterActivity(SimpleActivity.class);
                break;
            case 1:
                enterActivity(MoreItemActivity.class);
                break;
            case 2:
                enterActivity(WaterWallActivity.class);
                break;
            case 3:
                enterActivity(RefreshActivity.class);
                break;
            case 4:
                enterActivity(RdragActivity.class);
                break;
        }
    }
    public void enterActivity(Class clazz){
        Intent intent=new Intent(MainActivity.this,clazz);
        startActivity(intent);
    }
}   