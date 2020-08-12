package com.jack.baselibrary.utils

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource

fun <K, V, T : PageKeyedDataSource<K, V>> createPagedDataSourceFactory(
    creator: (() -> T)
): DataSource.Factory<K,V> {
    return object : DataSource.Factory<K,V>() {
        override fun create(): DataSource<K, V> {
            return creator.invoke()
        }
    }
}