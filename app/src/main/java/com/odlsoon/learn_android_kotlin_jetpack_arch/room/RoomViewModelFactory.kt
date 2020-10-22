package com.odlsoon.learn_android_kotlin_jetpack_arch.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class RoomViewModelFactory(
    private val roomRepository: RoomRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RoomViewModel(roomRepository) as T
    }

}