package com.farnadsoft.dadjoke

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable

class MainViewModel(): ViewModel() {

    val error:MutableLiveData<String> by lazy {MutableLiveData<String>()}
    val disposable:Disposable
        get() {
            TODO()
        }
    val repository : Repository
        get() {
            TODO()
        }

}