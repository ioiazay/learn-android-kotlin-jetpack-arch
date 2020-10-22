package com.odlsoon.learn_android_kotlin_jetpack_arch.paging.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_data")
class Data (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,
    var name : String
){
    constructor(): this(0, "")
}