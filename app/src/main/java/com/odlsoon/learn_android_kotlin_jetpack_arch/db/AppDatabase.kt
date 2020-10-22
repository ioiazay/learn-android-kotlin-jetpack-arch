package com.odlsoon.learn_android_kotlin_jetpack_arch.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.odlsoon.learn_android_kotlin_jetpack_arch.data_binding.DataBinding
import com.odlsoon.learn_android_kotlin_jetpack_arch.data_binding.DataBindingDao
import com.odlsoon.learn_android_kotlin_jetpack_arch.paging.model.Data
import com.odlsoon.learn_android_kotlin_jetpack_arch.paging.model.DataDao
import com.odlsoon.learn_android_kotlin_jetpack_arch.room.RoomDao


@Database(
    entities = [Data::class, DataBinding::class, com.odlsoon.learn_android_kotlin_jetpack_arch.room.Room::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract val dataDao: DataDao
    abstract val dataBindingDao: DataBindingDao
    abstract val roomDao: RoomDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun database(context: Context): AppDatabase{
            var instanceTemp = instance
            if(instanceTemp != null) return instanceTemp

            synchronized(this){
                val newInstance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_db")
                    .allowMainThreadQueries()
//                    .addMigrations(MigrationDatabase.instance.migrate3_4)
                    .build()

                instance = newInstance
                return newInstance
            }
        }
    }
}