package com.listocalixto.curso04semana01.ui.home.images

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.listocalixto.curso04semana01.R
import com.listocalixto.curso04semana01.core.Result
import com.listocalixto.curso04semana01.data.model.media.Media
import com.listocalixto.curso04semana01.data.model.media.MediaList
import com.listocalixto.curso04semana01.data.remote.media.MediaDataSource
import com.listocalixto.curso04semana01.databinding.FragmentImagesBinding
import com.listocalixto.curso04semana01.presentation.media.MediaViewModel
import com.listocalixto.curso04semana01.presentation.media.MediaViewModelFactory
import com.listocalixto.curso04semana01.repository.media.MediaRepoImpl
import com.listocalixto.curso04semana01.repository.media.RetrofitClient
import com.listocalixto.curso04semana01.ui.home.images.adapter.ImagesAdapter

class ImagesFragment : Fragment(R.layout.fragment_images), ImagesAdapter.OnItemClickListener {

    private val viewModel by activityViewModels<MediaViewModel> {
        MediaViewModelFactory(MediaRepoImpl(MediaDataSource(RetrofitClient.webService)))
    }

    private lateinit var binding: FragmentImagesBinding
    private lateinit var layoutManager: StaggeredGridLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentImagesBinding.bind(view)
        configRecyclerView()
        getResults()
    }

    private fun getResults() {
        viewModel.getMedia().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Loading -> {
                    dataLoading()
                }
                is Result.Success -> {
                    dataSuccess(result)
                }
                is Result.Failure -> {
                    dataFailure(result)
                }
            }
        })
    }

    private fun configRecyclerView() {
        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.layoutManager = layoutManager
    }

    private fun dataLoading() {
        Log.d("ViewModel", "Loading... ")
    }

    private fun dataSuccess(result: Result.Success<MediaList>) {
        Log.d("ViewModel", "Success!... ${result.data.data}")
        binding.recyclerView.adapter = ImagesAdapter(result.data.data, this)
    }

    private fun dataFailure(result: Result.Failure) {
        Log.d("ViewModel", "Failure... ${result.exception} ")
    }

    override fun onItemClick(media: Media) {
        TODO("Not yet implemented")
    }
}