package com.bwie.test.callback;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.bwie.test.adapter.WaterWallAdapter;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/21 21:20
 */

public class ItemTouchCallBack extends ItemTouchHelper.Callback{
    private WaterWallAdapter waterWallAdapter;

    //获取滑动的标记
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //位移标签
        int dragFlag=ItemTouchHelper.DOWN|ItemTouchHelper.UP|ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
        //移除标签
        int swipeFlag=ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlag,swipeFlag);
    }
    //是否进行移动，交换位置
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int oldPosition = viewHolder.getAdapterPosition();
        int newPosition = target.getAdapterPosition();
        waterWallAdapter.onMove(oldPosition,newPosition);
        return true;
    }
    public void setAdapter(WaterWallAdapter waterWallAdapter){
        this.waterWallAdapter=waterWallAdapter;
    }
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
    //移除
        waterWallAdapter.onDelete(viewHolder.getAdapterPosition());
    }
    
}
