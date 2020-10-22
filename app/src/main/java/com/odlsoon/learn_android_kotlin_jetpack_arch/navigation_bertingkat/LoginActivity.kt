package com.odlsoon.learn_android_kotlin_jetpack_arch.navigation_bertingkat

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odlsoon.learn_android_kotlin_jetpack_arch.R
import kotlinx.android.synthetic.main.login_act.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_act)

        initListener()
    }

    private fun initListener(){
        btn_login.setOnClickListener {
            DashboardActivity.startActivity(this)
        }
    }

    companion object{
        fun startActivity(context: Context){
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }
}
