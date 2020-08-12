package com.jack.baselibrary.extend

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> Fragment.createViewModel(noinline creator: (() -> T)? = null): T {
    return if (creator == null)
        ViewModelProvider(this).get(T::class.java)
    else
        ViewModelProvider(this, BaseViewModelFactory(creator)).get(T::class.java)
}

inline fun <reified T : ViewModel> Fragment.createViewModelBindOnActivity(noinline creator: (() -> T)? = null): T {
    return this.activity?.let { activity ->
        if (creator == null) {
            ViewModelProvider(activity).get(T::class.java)
        } else {
            ViewModelProvider(activity, BaseViewModelFactory(creator)).get(T::class.java)
        }
    } ?: throw Exception("Can't provide a viewModel because Activity is invalid")
}

inline fun <reified T : ViewModel> FragmentActivity.createViewModel(noinline creator: (() -> T)? = null): T {
    return if (creator == null)
        ViewModelProvider(this).get(T::class.java)
    else
        ViewModelProvider(this, BaseViewModelFactory(creator)).get(T::class.java)
}

class BaseViewModelFactory<T>(val creator: () -> T) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return creator() as T
    }
}