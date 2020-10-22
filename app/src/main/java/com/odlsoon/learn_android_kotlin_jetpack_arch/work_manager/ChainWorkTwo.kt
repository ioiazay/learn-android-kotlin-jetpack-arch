package com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class ChainWorkTwo(c: Context, wp: WorkerParameters): Worker(c, wp){

    override fun doWork(): Result {

        val string = inputData.getString(STRING_KEY)
        var finalString = if(string == "BERHASIL") "Berhasil"
        else "Gagal"

        val outputData = workDataOf(
            ChainWorkThree.STRING_KEY to finalString
        )

        return Result.success(outputData)
    }

    companion object{
        const val STRING_KEY = "com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager.ChainWorkTwo.STRING_KEY"
    }
}