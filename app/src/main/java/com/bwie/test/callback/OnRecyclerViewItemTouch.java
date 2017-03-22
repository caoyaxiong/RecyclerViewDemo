package com.bwie.test.callback;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/21 21:29
 */

public interface OnRecyclerViewItemTouch {
public void onMove(int oldPosition,int newPosition);
    public void onDelete(int position);
}
