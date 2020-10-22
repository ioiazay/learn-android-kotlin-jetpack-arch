package com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class WorkerThree (c: Context, wp: WorkerParameters): CoroutineWorker(c, wp){

    override suspend fun doWork(): Result {

        setProgress(workDataOf(PROGRESS_KEY to 0))
        val myString = inputData.getString(STRING_KEY)
        Log.d("TAG", "My String = $myString")

        setProgress(workDataOf(PROGRESS_KEY to 50))
        val outputData = workDataOf(
            STRING_KEY to "Sukses, Ayam Goreng Enak"
        )

        setProgress(workDataOf(PROGRESS_KEY to 100))
        return Result.success(outputData)
    }

    companion object{
        const val STRING_KEY = "com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager.WorkerThree.STRING_KEY"
        const val WORKER_TAG = "com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager.WorkerThree.WORKER_TAG"
        const val PROGRESS_KEY = "com.odlsoon.learn_android_kotlin_jetpack_arch.work_manager.WorkerThree.PROGRESS_KEY"
    }
}