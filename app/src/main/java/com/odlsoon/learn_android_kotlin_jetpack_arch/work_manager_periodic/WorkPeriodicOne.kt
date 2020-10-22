package com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager_periodic

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkPeriodicOne(c: Context, wp: WorkerParameters): Worker(c, wp) {

    override fun doWork(): Result {

        return Result.success()
    }

}