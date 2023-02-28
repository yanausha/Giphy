package com.example.giphy.domain.repository

import com.example.giphy.domain.entity.Gif

interface GifRepository {

    suspend fun getGifList(): List<Gif>
}
