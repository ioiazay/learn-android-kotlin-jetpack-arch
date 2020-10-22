package com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.*
import com.odlsoon.learn_android_kotlin_jetpack_arch.R
import kotlinx.android.synthetic.main.work_manager_act.*
import java.util.concurrent.TimeUnit

class WorkManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.work_manager_act)

        initListener()
    }

    private fun initListener(){
        btn_work_manager.setOnClickListener {
            initWorkManager()
        }

        btn_work_manager_constraint.setOnClickListener {
            initWorkManagerConstraint()
        }

        btn_work_manager_with_data.setOnClickListener {
            initWorkManagerWithData()
        }

        btn_work_chain.setOnClickListener {
            initWorkChain()
        }
    }

    private fun initWorkManager(){
        val oneReq = OneTimeWorkRequestBuilder<WorkerOne>()
            .setInitialDelay(5, TimeUnit.SECONDS)
            .build()
        WorkManager.getInstance(this).enqueue(oneReq)
    }

    private fun initWorkManagerConstraint(){
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val twoReq = OneTimeWorkRequestBuilder<WorkerTwo>()
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueue(twoReq)
    }

    private fun initWorkManagerWithData(){
        val data = workDataOf(
            WorkerThree.STRING_KEY to "Ayam Goreng"
        )

        val threeReq = OneTimeWorkRequestBuilder<WorkerThree>()
            .setInputData(data)
            .addTag(WorkerThree.WORKER_TAG)
            .build()

        WorkManager.getInstance(this).enqueue(threeReq)
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(threeReq.id).observe(this, Observer {

            if(it != null){
                val value = it.progress.getInt(WorkerThree.PROGRESS_KEY, 0)
                Log.d("TAG", "Progress = $value")

                when(it.state){
                    WorkInfo.State.SUCCEEDED -> {
                        val string = it.outputData.getString(WorkerThree.STRING_KEY)
                        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
                    }

                    WorkInfo.State.BLOCKED -> {

                    }

                    WorkInfo.State.CANCELLED -> {

                    }

                    WorkInfo.State.ENQUEUED -> {

                    }

                    WorkInfo.State.FAILED -> {
                        Toast.makeText(this, "Worker Three Gagal", Toast.LENGTH_SHORT).show()
                    }

                    WorkInfo.State.RUNNING -> {

                    }
                }
            }
        })
    }

    private fun initWorkChain(){
        val inputString = "BERHASIL"

        val data = Data.Builder()
            .putString(ChainWorkOne.STRING_KEY, inputString)
            .build()

        val oneReq = OneTimeWorkRequestBuilder<ChainWorkOne>()
            .setInputData(data)
            .build()
        val twoReq = OneTimeWorkRequestBuilder<ChainWorkTwo>().build()
        val threeReq = OneTimeWorkRequestBuilder<ChainWorkThree>().build()

        WorkManager.getInstance(this)
            .beginWith(oneReq)
            .then(twoReq)
            .then(threeReq)
            .enqueue()

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(threeReq.id).observe(this, Observer {
            if(it != null){

                when(it.state){
                    WorkInfo.State.SUCCEEDED -> {
                        Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()
                    }

                    WorkInfo.State.FAILED -> {
                        Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        })
    }
}