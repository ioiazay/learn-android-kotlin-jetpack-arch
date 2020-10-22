package com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class ChainWorkThree(c: Context, wp: WorkerParameters): Worker(c, wp) {

    override fun doWork(): Result {
        val string = inputData.getString(STRING_KEY)

        return if(string == "Berhasil") Result.success()
        else Result.failure()
    }

    companion object{
        const val STRING_KEY = "com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager.ChainWorkThree.STRING_KEY"
    }
}