package com.listocalixto.curso04semana01.repository.media

import com.google.gson.GsonBuilder
import com.listocalixto.curso04semana01.application.AppConstants
import com.listocalixto.curso04semana01.data.model.media.MediaList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MediaWebService {

    @GET("me/media")
    suspend fun getMedia(
        @Query("fields") fields: String,
        @Query("access_token") accessToken: String
    ) : MediaList
}

object RetrofitClient {

    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(MediaWebService::class.java)
    }

}