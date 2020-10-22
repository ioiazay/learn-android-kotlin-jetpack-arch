package com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager_thread

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkManagerWorkerThread(c: Context, wp: WorkerParameters): Worker(c, wp) {

    override fun doWork(): ListenableWorker.Result {

        if(isStopped){

        }


        return ListenableWorker.Result.success()
    }
}