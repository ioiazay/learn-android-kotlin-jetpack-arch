package com.odlsoon.learn_android_kotlin_jetpack_arch.paging.model

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.odlsoon.learn_android_kotlin_jetpack_arch.db.BaseDao

@Dao
interface DataDao: BaseDao<Data> {

    @Query("SELECT * FROM table_data")
    fun getAllData(): List<Data>

    @Query("SELECT * FROM table_data")
    fun getAllDataPaged(): DataSource.Factory<Int, Data>

}