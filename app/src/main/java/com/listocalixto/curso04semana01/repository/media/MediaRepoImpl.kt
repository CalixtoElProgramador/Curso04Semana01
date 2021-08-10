package com.listocalixto.curso04semana01.repository.media

import com.listocalixto.curso04semana01.data.model.media.MediaList
import com.listocalixto.curso04semana01.data.remote.media.MediaDataSource

class MediaRepoImpl(private val dataSource: MediaDataSource): MediaRepo {

    override suspend fun getMedia(): MediaList = dataSource.getMedia()
}