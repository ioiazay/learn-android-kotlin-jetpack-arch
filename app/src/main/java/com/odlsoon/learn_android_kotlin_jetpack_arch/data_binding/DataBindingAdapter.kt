package com.odlsoon.learn_android_kotlin_jetpack_arch.data_binding

import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.odlsoon.learn_android_kotlin_jetpack_arch.R

@BindingAdapter("app:data_size")
fun setTextViewColor(textView: TextView, size: Int){
    if(size > 100) textView.setTextColor(ContextCompat.getColor(textView.context, R.color.colorAccent))
    else textView.setTextColor(ContextCompat.getColor(textView.context, R.color.colorPrimary))
}