package com.odlsoon.learn_android_kotlin_jetpack_arch.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.odlsoon.learn_android_kotlin_jetpack_arch.R

class RoomActivity : AppCompatActivity() {

    private val viewModel by viewModels<RoomViewModel> {
        Injector.providerRoomViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.room_act)
    }
}
