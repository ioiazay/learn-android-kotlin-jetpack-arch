package com.odlsoon.learn_android_kotlin_jetpack_arch.navigation_bertingkat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.odlsoon.learn_android_kotlin_jetpack_arch.R

class NavigationBertingkatThreeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.navigation_bertingkat_three_frag, container, false)
    }
}
