package com.odlsoon.learn_android_kotlin_jetpack_arch.data_binding

import androidx.room.Dao
import androidx.room.Query
import com.odlsoon.learn_android_kotlin_jetpack_arch.db.BaseDao

@Dao
interface DataBindingDao: BaseDao<DataBinding> {

    @Query("SELECT * FROM table_data_binding")
    fun getDataBindings(): List<DataBinding>

}