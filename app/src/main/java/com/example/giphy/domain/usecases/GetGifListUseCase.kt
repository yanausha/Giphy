package com.example.giphy.domain.usecases

import com.example.giphy.domain.repository.GifRepository
import javax.inject.Inject

class GetGifListUseCase @Inject constructor(private val repository: GifRepository) {

    suspend operator fun invoke() = repository.getGifList()
}
