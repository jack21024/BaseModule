package com.jack.baselibrary.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*


abstract class BaseViewModel : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    protected var viewModelJob: Job = Job()
    protected val viewModelScope by lazy {
        CoroutineScope(Dispatchers.Main + viewModelJob)
    }

    fun start() {
        viewModelJob = viewModelScope.launch {
            isLoading.value = true
            loadData()
            isLoading.value = false
        }
    }

    protected open suspend fun loadData() = Unit

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}