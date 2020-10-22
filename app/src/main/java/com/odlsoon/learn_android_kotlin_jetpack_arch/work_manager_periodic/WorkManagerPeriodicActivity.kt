package com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager_periodic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.*
import com.odlsoon.learn_android_kotlin_jetpack_arch.R
import java.util.concurrent.TimeUnit

class WorkManagerPeriodicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.work_manager_periodic_act)

        initPeriodicOne()
    }

    private fun initPeriodicOne(){
        val constraint = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val oneReqPeriodic = PeriodicWorkRequestBuilder<WorkPeriodicOne>(2, TimeUnit.SECONDS)
            .setConstraints(constraint)
            .build()

        WorkManager.getInstance(this).enqueue(oneReqPeriodic)
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneReqPeriodic.id).observe(this, Observer {
            if(it != null){
                when(it.state){
                    WorkInfo.State.SUCCEEDED -> {
                        Toast.makeText(this, "Berhasil Periodik 2 Detik", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

}
