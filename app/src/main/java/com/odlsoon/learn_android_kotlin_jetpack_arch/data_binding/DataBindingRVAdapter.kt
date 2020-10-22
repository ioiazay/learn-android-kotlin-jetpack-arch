package com.odlsoon.learn_android_kotlin_jetpack_arch.data_binding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.odlsoon.learn_android_kotlin_jetpack_arch.R
import kotlinx.android.synthetic.main.data_item.view.*

class DataBindingRVAdapter(
    private val dataBindingList: List<DataBinding>
): RecyclerView.Adapter<DataBindingRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.data_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataBindingList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataBindingList[position])
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v){
        private val tvName = v.tv_name

        fun onBind(dataBinding: DataBinding){
            tvName.text = dataBinding.name
        }
    }
}