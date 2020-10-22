package com.odlsoon.learn_android_kotlin_jetpack_arch.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_room")
class Room(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,
    var name: String? = ""
){
    constructor(): this(null, "")
}