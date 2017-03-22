package com.bwie.test.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwie.test.R;

import java.net.PortUnreachableException;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/21 13:42
 */

public class RsimpleHolder extends RecyclerView.ViewHolder {

    public final TextView textView;

    public RsimpleHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
    }
}
