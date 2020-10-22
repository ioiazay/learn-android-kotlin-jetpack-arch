package com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class ChainWorkOne(c: Context, wp: WorkerParameters): Worker(c, wp) {

    override fun doWork(): Result {
        val string = inputData.getString(STRING_KEY)

        val outputData = workDataOf(
            ChainWorkTwo.STRING_KEY to string
        )

        return Result.success(outputData)
    }

    companion object{
        const val STRING_KEY = "com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager.ChainWorkOne.STRING_KEY"
    }
}