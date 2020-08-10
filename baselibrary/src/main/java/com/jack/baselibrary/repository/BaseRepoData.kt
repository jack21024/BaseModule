package com.jack.baselibrary.repository

import androidx.lifecycle.MutableLiveData

open class BaseRepoData<Data> {
    val viewData = MutableLiveData<Data>()
}