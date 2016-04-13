package com.example.test.samplemasterdetail.decorators;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by evin on 3/14/16.
 */
public class SpacesItemDecorator extends RecyclerView.ItemDecoration {
    private final int mSpace;

    public SpacesItemDecorator(int space) {
        this.mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.left = mSpace;
        outRect.bottom = mSpace;
        outRect.right = mSpace;

        if (parent.getChildAdapterPosition(view) < 1){
            outRect.top = mSpace;
        }
    }
}
