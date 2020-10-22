package com.odlsoon.learn_android_kotlin_jetpack_arch.navigation_bertingkat

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odlsoon.learn_android_kotlin_jetpack_arch.R

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_act)
    }

    companion object{
        fun startActivity(context: Context){
            context.startActivity(Intent(context, DashboardActivity::class.java))
        }
    }
}
