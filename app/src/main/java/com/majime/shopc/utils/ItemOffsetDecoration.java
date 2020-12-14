package com.majime.shopc.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

    private int mItemOffset;
    private boolean isGrid;

    public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId, boolean isGrid) {
        mItemOffset = context.getResources().getDimensionPixelSize(itemOffsetId);
        this.isGrid = isGrid;
    }

    @Override
    public void getItemOffsets(
            Rect outRect, View view, RecyclerView parent,
            RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if(isGrid) {
            if (parent.getChildLayoutPosition(view) % 2 == 1) {
                outRect.left = mItemOffset;
            }
            outRect.bottom = mItemOffset;
        } else {
            if (parent.getChildLayoutPosition(view) != 0) {
                outRect.left = mItemOffset;
            }
        }

    }
}
