package com.odlsoon.learn_android_kotlin_jetpack_arch.paging.model

import android.content.Context
import android.widget.Toast
import androidx.paging.PagedList
import com.odlsoon.learn_android_kotlin_jetpack_arch.db.AppDatabase

class DataPGBoundaryCallback(
    private val context: Context
): PagedList.BoundaryCallback<Data>() {

    override fun onZeroItemsLoaded() {
        initFirstData()
    }

    override fun onItemAtEndLoaded(itemAtEnd: Data) {
        initDataFromServer()
    }

    private fun initFirstData(){
        val dao = AppDatabase.database(context).dataDao

        for(i in 1..100){
            val data = Data(null, "Name: $i")
            dao.insert(data)
        }

        Toast.makeText(context, "Data Dummy Successfully Added", Toast.LENGTH_SHORT).show()
    }

    private fun initDataFromServer(){
        Toast.makeText(context, "No More Data From Server", Toast.LENGTH_SHORT).show()
    }
}