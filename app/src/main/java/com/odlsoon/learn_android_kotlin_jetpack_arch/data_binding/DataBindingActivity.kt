package com.odlsoon.learn_android_kotlin_jetpack_arch.data_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.odlsoon.learn_android_kotlin_jetpack_arch.R
import com.odlsoon.learn_android_kotlin_jetpack_arch.databinding.DataBindingActBinding
import kotlinx.android.synthetic.main.data_binding_act.*

class DataBindingActivity : AppCompatActivity() {
    private val viewModel by viewModels<DataBindingViewModel> {
        Injector.providerDataBindingViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
        initViewModel()
        initRecyclerView()
    }

    private fun initDataBinding(){
        val binding = DataBindingUtil.setContentView<DataBindingActBinding>(this, R.layout.data_binding_act)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
    }

    private fun initViewModel(){
        viewModel.initDummyData()
        viewModel.getAllDataBinding()

        viewModel.isHuman.observe(this, Observer {
            if(it) Toast.makeText(this, "Ya Kamu Manusia", Toast.LENGTH_SHORT).show()
            else Toast.makeText(this, "Kamu Bukan Manusia", Toast.LENGTH_SHORT).show()
        })

        viewModel.dataBindings.observe(this, Observer {
            rv_data_binding.adapter?.notifyDataSetChanged()
        })
    }

    private fun initRecyclerView(){
        rv_data_binding.apply{
            adapter = DataBindingRVAdapter(viewModel.dataBindings.value!!)
            layoutManager = LinearLayoutManager(this@DataBindingActivity)
            addItemDecoration(DividerItemDecoration(this@DataBindingActivity, DividerItemDecoration.VERTICAL))
            itemAnimator = DefaultItemAnimator()
        }
    }

}
