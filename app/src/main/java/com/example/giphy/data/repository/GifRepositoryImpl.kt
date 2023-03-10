package com.example.giphy.data.repository

import com.example.giphy.data.mappers.GifMapper
import com.example.giphy.data.network.ApiService
import com.example.giphy.domain.entity.Gif
import com.example.giphy.domain.repository.GifRepository
import javax.inject.Inject

class GifRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: GifMapper
) : GifRepository {

    override suspend fun getGifList(): List<Gif> {
        val response = apiService.getGifList()
        return mapper.mapListDtoToListEntity(checkNotNull(response.body()))
    }

    override suspend fun searchGifList(str: String): List<Gif>? {
        val response = apiService.searchGifList(str)
        return if (response.isSuccessful) mapper.mapListDtoToListEntity(response.body()!!)
        else null
    }
}