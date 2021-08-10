package com.listocalixto.curso04semana01.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.listocalixto.curso04semana01.R
import com.listocalixto.curso04semana01.databinding.FragmentHomeBinding
import com.listocalixto.curso04semana01.ui.home.videos.VideosFragment
import com.listocalixto.curso04semana01.ui.home.adapter.HomeAdapter
import com.listocalixto.curso04semana01.ui.home.images.ImagesFragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        initAdapter()
        configTabLayout()
    }

    private fun configTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> { tab.text = "Images" }
                1 -> { tab.text = "Videos" }
            }
        }.attach()
    }

    private fun initAdapter() {
        val fragmentList = arrayListOf(
            ImagesFragment(),
            VideosFragment()
        )
        adapter = HomeAdapter(fragmentList, this)
        binding.viewPager.adapter = adapter
    }

}