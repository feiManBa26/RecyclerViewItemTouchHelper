package com.growing.recyclerviewitemtouch.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.growing.recyclerviewitemtouch.R;

/**
 * Created by 明正 on 2017/5/28.
 */

public class GridViewHolder extends RecyclerView.ViewHolder {

    public final TextView mTxt;

    public GridViewHolder(View itemView) {
        super(itemView);
        mTxt = (TextView) itemView.findViewById(R.id.txt);

    }
}
