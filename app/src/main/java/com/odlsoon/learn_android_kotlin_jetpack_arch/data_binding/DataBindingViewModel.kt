package com.odlsoon.learn_android_kotlin_jetpack_arch.data_binding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataBindingViewModel(
    private val dataBindingRepository: DataBindingRepository
): ViewModel() {
    val dataBindings = MutableLiveData<List<DataBinding>>(listOf())
    val isHuman = MutableLiveData<Boolean>(true)

    fun initDummyData(){
        dataBindingRepository.initDummyData()
    }

    fun getAllDataBinding(){
        val data = dataBindingRepository.getAllDataBinding()
        dataBindings.value = data
    }

}