package com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkerTwo(
    private val c: Context,
    wp: WorkerParameters
): Worker(c, wp) {

    override fun doWork(): Result {
        Log.d("TAG", "Work Two")
        return Result.success()
    }

}