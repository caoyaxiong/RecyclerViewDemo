package com.bwie.test.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwie.test.R;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/21 20:39
 */

public class RsecondTypeViewHolder extends RecyclerView.ViewHolder {

    public final TextView text;

    public RsecondTypeViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.text);
    }
}
