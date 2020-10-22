package com.odlsoon.learn_android_kotlin_jetpack_arch.data_binding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class DataBindingViewModelFactory(
    private val dataBindingRepository: DataBindingRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DataBindingViewModel(dataBindingRepository) as T
    }
}