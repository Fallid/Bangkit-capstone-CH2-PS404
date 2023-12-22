package com.naufal.capstonech2ps404.data.retrofit

import com.naufal.capstonech2ps404.model.ResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService{

    @GET("recommendations/{city}")
    suspend fun getPlaces(@Path("city") city:String): Response<List<ResponseItem>>
}