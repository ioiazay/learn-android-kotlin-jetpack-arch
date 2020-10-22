package com.odlsoon.learn_android_kotlin_jetpack_arch.room

import android.content.Context
import com.odlsoon.learn_android_kotlin_jetpack_arch.db.AppDatabase

object Injector {

    private fun getRoomRepository(context: Context): RoomRepository{
        return RoomRepository(AppDatabase.database(context).roomDao)
    }

    fun providerRoomViewModelFactory(context: Context): RoomViewModelFactory{
        return RoomViewModelFactory(getRoomRepository(context))
    }

}