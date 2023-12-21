package com.naufal.capstonech2ps404.data.retrofit

import com.naufal.capstonech2ps404.model.Response
import retrofit2.http.GET

interface ApiService{

    @GET("recommendations/Bandung")
    suspend fun getPlaces(): Response
}