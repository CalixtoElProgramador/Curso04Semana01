package com.listocalixto.curso04semana01.data.model.media

data class Media(
    val caption: String = "",
    val id: String = "",
    val media_type: String = "",
    val media_url: String = "",
    val permalink: String = "",
    val timestamp: String = "",
    val username: String = "",
)

data class MediaList(val data: List<Media>)