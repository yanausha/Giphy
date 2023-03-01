package com.example.giphy.data.network

import com.example.giphy.data.network.model.GifListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("gifs/trending?api_key=3CoURoLhUwIwuMvxOs3Wq5jjFt1K2y9X&limit=25")
    suspend fun getGifList(): Response<GifListDto>

    @GET("gifs/search?api_key=3CoURoLhUwIwuMvxOs3Wq5jjFt1K2y9X&q=str&limit=25")
    suspend fun searchGifList(
        @Query("q") str: String
    ): Response<GifListDto>
}