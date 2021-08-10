package com.listocalixto.curso04semana01.repository.media

import com.listocalixto.curso04semana01.data.model.media.MediaList

interface MediaRepo {

    suspend fun getMedia(): MediaList

}