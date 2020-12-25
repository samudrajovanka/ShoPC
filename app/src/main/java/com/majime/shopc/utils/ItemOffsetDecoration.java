package com.majime.shopc.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

    private int mItemOffsetLeft, mItemOffsetTop, mItemOffsetRight, mItemOffsetBottom;
    private String used;

    public ItemOffsetDecoration(
            @NonNull Context context,
            @DimenRes int itemOffsetLeft,
            @DimenRes int itemOffsetTop,
            @DimenRes int itemOffsetRight,
            @DimenRes int itemOffsetBottom,
            String used
    ) {
        mItemOffsetLeft = context.getResources().getDimensionPixelSize(itemOffsetLeft);
        mItemOffsetTop = context.getResources().getDimensionPixelSize(itemOffsetTop);
        mItemOffsetRight = context.getResources().getDimensionPixelSize(itemOffsetRight);
        mItemOffsetBottom = context.getResources().getDimensionPixelSize(itemOffsetBottom);
        this.used = used;
    }

    @Override
    public void getItemOffsets(
            Rect outRect, View view, RecyclerView parent, RecyclerView.State state
    ) {
        super.getItemOffsets(outRect, view, parent, state);

        if(used.equalsIgnoreCase("all")) {
            outRect.set(mItemOffsetLeft, mItemOffsetTop, mItemOffsetRight, mItemOffsetBottom);
        } else if(used.equalsIgnoreCase("first")) {
            if(parent.getChildLayoutPosition(view) == 0) {
                outRect.set(mItemOffsetLeft, mItemOffsetTop, mItemOffsetRight, mItemOffsetBottom);
            }
        } else if(used.equalsIgnoreCase("odd")) {
            if(parent.getChildLayoutPosition(view) % 2 == 1) {
                outRect.set(mItemOffsetLeft, mItemOffsetTop, mItemOffsetRight, mItemOffsetBottom);
            }
        } else if(used.equalsIgnoreCase("not first")) {
            if(parent.getChildLayoutPosition(view) != 0) {
                outRect.set(mItemOffsetLeft, mItemOffsetTop, mItemOffsetRight, mItemOffsetBottom);
            }
        }
    }

}
