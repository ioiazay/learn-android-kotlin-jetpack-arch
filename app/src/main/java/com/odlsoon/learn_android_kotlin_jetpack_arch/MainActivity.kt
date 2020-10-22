package com.odlsoon.learn_android_kotlin_jetpack_arch

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import com.google.android.material.button.MaterialButton
import com.odlsoon.learn_android_kotlin_jetpack_arch.data_binding.DataBindingActivity
import com.odlsoon.learn_android_kotlin_jetpack_arch.navigation.NavigationActivity
import com.odlsoon.learn_android_kotlin_jetpack_arch.navigation_bertingkat.NavigationBertingkatActivity
import com.odlsoon.learn_android_kotlin_jetpack_arch.paging.PagingActivity
import com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager.WorkManagerActivity
import com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager_periodic.WorkManagerPeriodicActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLevel()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun initLevel(){
        val components = mutableMapOf(
            "Navigation" to NavigationActivity::class.java,
            "Navigation Bertingkat" to NavigationBertingkatActivity::class.java,
            "Work Manager" to WorkManagerActivity::class.java,
            "Work Manager Periodik" to WorkManagerPeriodicActivity::class.java,
            "Paging From Local Storage" to PagingActivity::class.java,
            "Data Binding" to DataBindingActivity::class.java
        )

        components.forEach {
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            val button = MaterialButton(this, null, R.attr.materialButtonStyle)

            params.setMargins(16, 16, 16, 16)
            button.layoutParams = params
            button.text = it.key
            button.setOnClickListener {_ ->
                startActivity(Intent(this, it.value))
            }

            ll_main.addView(button)
        }
    }
}
