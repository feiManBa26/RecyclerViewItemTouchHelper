package com.growing.recyclerviewitemtouch;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.growing.recyclerviewitemtouch.adapter.ItemTouchRecyclerViewAdapter;
import com.growing.recyclerviewitemtouch.callback.MyRecyclerViewTouchCallBack;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.left = 2;
                outRect.top = 2;
                outRect.bottom = 2;
            }
        });

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? gridLayoutManager.getSpanCount() : 1;
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        ArrayList<String> mStrings = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            mStrings.add("item  "+i);
        }
        ItemTouchRecyclerViewAdapter adapter = new ItemTouchRecyclerViewAdapter(mStrings);
        mRecyclerView.setAdapter(adapter);
        MyRecyclerViewTouchCallBack callBack= new MyRecyclerViewTouchCallBack(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callBack);
        touchHelper.attachToRecyclerView(mRecyclerView);
    }
}
