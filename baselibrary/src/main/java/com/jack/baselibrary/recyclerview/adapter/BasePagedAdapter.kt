package com.jack.baselibrary.recyclerview.adapter

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.jack.baselibrary.recyclerview.item.BaseCardItem
import com.jack.baselibrary.recyclerview.viewholder.BaseViewHolder

abstract class BasePagedAdapter<T: BaseCardItem>(diff: DiffUtil.ItemCallback<T> = createDefaultDiff()) :
    PagedListAdapter<T, BaseViewHolder<T>>(diff)

fun <T: BaseCardItem> createDefaultDiff() = object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem.id == newItem.id
    }

