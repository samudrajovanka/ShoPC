package com.majime.shopc.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

    private int mItemOffset;

    public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
        mItemOffset = context.getResources().getDimensionPixelSize(itemOffsetId);
    }

    @Override
    public void getItemOffsets(
            Rect outRect, View view, RecyclerView parent,
            RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
            if (parent.getChildLayoutPosition(view) % 2 == 1) {
                outRect.left = mItemOffset;
            }
            outRect.bottom = mItemOffset;

    }
}
