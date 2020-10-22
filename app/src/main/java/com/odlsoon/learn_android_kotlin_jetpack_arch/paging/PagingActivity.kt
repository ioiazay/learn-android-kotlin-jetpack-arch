package com.odlsoon.learn_android_kotlin_jetpack_arch.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.paging.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.odlsoon.learn_android_kotlin_jetpack_arch.R
import com.odlsoon.learn_android_kotlin_jetpack_arch.db.AppDatabase
import com.odlsoon.learn_android_kotlin_jetpack_arch.paging.model.Data
import com.odlsoon.learn_android_kotlin_jetpack_arch.paging.model.DataPGAdapter
import com.odlsoon.learn_android_kotlin_jetpack_arch.paging.model.DataPGBoundaryCallback
import kotlinx.android.synthetic.main.paging_act.*

class PagingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paging_act)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        val dao = AppDatabase.database(this).dataDao
        val dataSource = dao.getAllDataPaged()
        val dataBoundaryCallback = DataPGBoundaryCallback(this)
        val adp = DataPGAdapter()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(100)
            .build()

        val data = LivePagedListBuilder(dataSource, config)
            .setBoundaryCallback(dataBoundaryCallback)
            .build()

        data.observe(this, Observer {
            adp.submitList(it)
            adp.notifyDataSetChanged()
        })

        rv_data.apply {
            adapter = adp
            layoutManager = LinearLayoutManager(this@PagingActivity)
            addItemDecoration(DividerItemDecoration(this@PagingActivity, DividerItemDecoration.VERTICAL))
        }
    }
}
