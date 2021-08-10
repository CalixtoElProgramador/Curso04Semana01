package com.listocalixto.curso04semana01.presentation.media

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.listocalixto.curso04semana01.core.Result
import com.listocalixto.curso04semana01.repository.media.MediaRepo
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MediaViewModel(private val repo: MediaRepo) : ViewModel() {

    fun getMedia() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repo.getMedia()))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }
}

class MediaViewModelFactory(private val repo: MediaRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MediaRepo::class.java).newInstance(repo)
    }
}