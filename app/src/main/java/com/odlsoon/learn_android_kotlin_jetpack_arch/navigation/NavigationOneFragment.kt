package com.odlsoon.learn_android_kotlin_jetpack_arch.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.odlsoon.learn_android_kotlin_jetpack_arch.R
import kotlinx.android.synthetic.main.navigation_one_frag.view.*

class NavigationOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.navigation_one_frag, container, false)

        initListener(view)
        return view
    }

    private fun initListener(v: View){
        v.btn_goto_navigation_two.setOnClickListener {
            val action = NavigationOneFragmentDirections.actionOpenNavTwoFrag()
            findNavController().navigate(action)
        }
    }

}
