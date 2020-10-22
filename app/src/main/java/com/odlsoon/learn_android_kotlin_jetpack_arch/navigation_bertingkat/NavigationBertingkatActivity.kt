package com.odlsoon.learn_android_kotlin_jetpack_arch.navigation_bertingkat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odlsoon.learn_android_kotlin_jetpack_arch.R

class NavigationBertingkatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_bertingkat_act)

        checkLoginStatus()
    }

    private fun checkLoginStatus(){
        val isLogged = false

        if(isLogged){
            DashboardActivity.startActivity(this)
        }else{
            LoginActivity.startActivity(this)
        }
    }
}
