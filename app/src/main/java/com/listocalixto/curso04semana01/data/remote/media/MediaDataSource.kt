package com.listocalixto.curso04semana01.data.remote.media

import com.listocalixto.curso04semana01.application.AppConstants
import com.listocalixto.curso04semana01.data.model.media.MediaList
import com.listocalixto.curso04semana01.repository.media.MediaWebService

class MediaDataSource(private val webService: MediaWebService) {

    suspend fun getMedia(): MediaList =
        webService.getMedia(AppConstants.FIELDS_MEDIA, AppConstants.ACCESS_TOKEN)

}