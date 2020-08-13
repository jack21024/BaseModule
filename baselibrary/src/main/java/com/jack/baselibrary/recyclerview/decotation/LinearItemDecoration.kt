package com.jack.baselibrary.recyclerview.decotation

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class LinearItemDecoration(
    private val space: Int,
    private val enableTop: Boolean = false,
    private val enableVertical: Boolean = false
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if(enableTop) {
            if (parent.getChildLayoutPosition(view) == 0)
                outRect.top = space;
        }
        if(enableVertical) {
            outRect.left = space
            outRect.right = space
        }
        outRect.bottom = space
    }
}