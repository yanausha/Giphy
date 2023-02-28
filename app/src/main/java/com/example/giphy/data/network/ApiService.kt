package com.example.giphy.data.network

import com.example.giphy.data.network.model.GifListDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("gifs/trending?api_key=3CoURoLhUwIwuMvxOs3Wq5jjFt1K2y9X")
    suspend fun getGifList(): Response<GifListDto>
}