package com.jack.baselibrary.common

abstract class BaseInstanceObject {
    val TAG = BaseInstanceObject::class.java.simpleName

    private var isInitialed = false

    abstract fun onInit()

    fun init() {
        if(!isInitialed) {
            onInit()
            isInitialed = true
        } else {
            throw Exception("$TAG already initialed.")
        }

    }
}