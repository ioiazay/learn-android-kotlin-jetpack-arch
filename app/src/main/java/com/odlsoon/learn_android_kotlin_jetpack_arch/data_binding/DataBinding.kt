package com.odlsoon.learn_android_kotlin_jetpack_arch.data_binding

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_data_binding")
class DataBinding(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,
    var name: String? = ""
)