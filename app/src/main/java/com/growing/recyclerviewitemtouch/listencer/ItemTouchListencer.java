package com.growing.recyclerviewitemtouch.listencer;

/**
 * Created by 明正 on 2017/5/28.
 */

public interface ItemTouchListencer {
    /**
     * 拖动回调接口
     *
     * @param startIndex --开始位置
     * @param endIndex   --交换结束位置
     */
    void itemMove(int startIndex, int endIndex);

    /**
     * 滑动删除
     *
     * @param delIndex
     */
    void itemSwipe(int delIndex);
}
