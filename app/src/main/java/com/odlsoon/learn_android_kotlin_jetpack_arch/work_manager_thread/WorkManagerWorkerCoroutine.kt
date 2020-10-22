package com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager_thread

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class WorkManagerWorkerCoroutine(c: Context, wp: WorkerParameters): CoroutineWorker(c, wp) {

    override suspend fun doWork(): Result {

        return Result.success()
    }
}