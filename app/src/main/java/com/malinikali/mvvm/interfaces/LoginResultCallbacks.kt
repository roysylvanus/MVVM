package com.malinikali.mvvm.interfaces

interface LoginResultCallbacks {
    fun onSuccess(message:String)

    fun onError(message: String)
}