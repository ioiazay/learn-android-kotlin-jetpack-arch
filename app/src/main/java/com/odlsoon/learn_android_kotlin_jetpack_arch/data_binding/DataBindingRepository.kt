package com.odlsoon.learn_android_kotlin_jetpack_arch.data_binding

class DataBindingRepository(
    private val dataBindingDao: DataBindingDao
) {

    fun initDummyData(){
        val data = dataBindingDao.getDataBindings()

        if(data.isEmpty()){
            for(i in 1..100){
                dataBindingDao.insert(DataBinding(null, "Name: $i"))
            }
        }
    }

    fun getAllDataBinding() = dataBindingDao.getDataBindings()

}