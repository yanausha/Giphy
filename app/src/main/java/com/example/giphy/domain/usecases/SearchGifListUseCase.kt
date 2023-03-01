package com.example.giphy.domain.usecases

import com.example.giphy.domain.repository.GifRepository
import javax.inject.Inject

class SearchGifListUseCase @Inject constructor(
    private val repository: GifRepository
) {

    suspend operator fun invoke(str: String) = repository.searchGifList(str)
}