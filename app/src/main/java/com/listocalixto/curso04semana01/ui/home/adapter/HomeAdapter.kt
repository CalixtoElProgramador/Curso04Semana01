package com.listocalixto.curso04semana01.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.listocalixto.curso04semana01.ui.home.HomeFragment

class HomeAdapter(
    list: ArrayList<Fragment>,
    fragment: HomeFragment
) : FragmentStateAdapter(fragment) {

    private val fragmentList = list

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }



}