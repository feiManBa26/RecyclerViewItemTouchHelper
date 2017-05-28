package com.growing.recyclerviewitemtouch.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.growing.recyclerviewitemtouch.R;
import com.growing.recyclerviewitemtouch.listencer.ItemTouchListencer;
import com.growing.recyclerviewitemtouch.viewHolder.GridViewHolder;
import com.growing.recyclerviewitemtouch.viewHolder.HeaderViewHolder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 明正 on 2017/5/28.
 */

public class ItemTouchRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchListencer {

    private static final int TYPE_HEADER_VIEW = 0;
    private static final int TYPE_CONTENT = 1;
    private ArrayList<String> mStrings;
    private View mHeaderView;

    public ItemTouchRecyclerViewAdapter(ArrayList<String> strings) {
        mStrings = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER_VIEW) {
            View view = View.inflate(parent.getContext(), R.layout.heander_view_item, null);
            return new HeaderViewHolder(view);
        } else if (viewType == TYPE_CONTENT) {
            View view = View.inflate(parent.getContext(), R.layout.gridview_item, null);
            return new GridViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof GridViewHolder) {
            GridViewHolder gridViewHolder = (GridViewHolder) holder;
            String str = mStrings.get(position - 1);
            gridViewHolder.mTxt.setText(str);
        }else if(holder instanceof HeaderViewHolder){
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
        }
    }

    @Override
    public int getItemCount() {
//        return mHeaderView != null ? mStrings.size() + 1 : mStrings.size();
        return mStrings.size();

    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER_VIEW;
        } else {
            return TYPE_CONTENT;
        }
    }

    /**
     * 拖动回调接口
     *
     * @param startIndex --开始位置
     * @param endIndex   --交换结束位置
     */
    @Override
    public void itemMove(int startIndex, int endIndex) {
        if (startIndex == 0 || endIndex == 0) {
            return;
        }
        Collections.swap(mStrings, startIndex, endIndex);
        notifyItemMoved(startIndex, endIndex);
    }

    /**
     * 滑动删除
     *
     * @param delIndex
     */
    @Override
    public void itemSwipe(int delIndex) {

    }
}
