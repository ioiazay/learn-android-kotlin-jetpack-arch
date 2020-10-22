package com.odlsoon.learn_android_kotlin_jetpack_arch.data_binding

import android.content.Context
import com.odlsoon.learn_android_kotlin_jetpack_arch.db.AppDatabase

object Injector {

    private fun getDataBindingRepository(context: Context): DataBindingRepository{
        return DataBindingRepository(AppDatabase.database(context).dataBindingDao)
    }

    fun providerDataBindingViewModelFactory(context: Context): DataBindingViewModelFactory{
        return DataBindingViewModelFactory(getDataBindingRepository(context))
    }

}