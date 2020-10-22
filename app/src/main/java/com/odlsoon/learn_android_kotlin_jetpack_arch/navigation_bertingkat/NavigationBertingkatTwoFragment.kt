package com.odlsoon.learn_android_kotlin_jetpack_arch.navigation_bertingkat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.odlsoon.learn_android_kotlin_jetpack_arch.R
import kotlinx.android.synthetic.main.navigation_bertingkat_two_frag.view.*

class NavigationBertingkatTwoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.navigation_bertingkat_two_frag, container, false)

        initListener(view)
        return view
    }

    private fun initListener(v: View){
        v.btn_three.setOnClickListener {
            val action = NavigationBertingkatTwoFragmentDirections.actionOpenNavBertingkatThreeFrag()

            // Note for the future: Muncul error ketika memanggil findNavController 2x di kelas yang berbeda - is unknown to this NavController
            findNavController().navigate(action)
        }
    }

}
