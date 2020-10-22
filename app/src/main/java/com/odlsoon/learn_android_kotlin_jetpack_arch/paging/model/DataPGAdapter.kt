package com.odlsoon.learn_android_kotlin_jetpack_arch.paging.model

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.odlsoon.learn_android_kotlin_jetpack_arch.R
import kotlinx.android.synthetic.main.data_item.view.*

class DataPGAdapter: PagedListAdapter<Data, DataPGAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.data_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val tvName = view.tv_name

        fun onBind(data: Data){
            tvName.text = data.name
        }
    }

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data) = oldItem.id == newItem.id
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Data, newItem: Data) = oldItem == newItem
        }
    }

}