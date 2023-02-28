package com.example.giphy.domain.entity

import javax.inject.Inject

data class Gif @Inject constructor(
    val imageUrl: String?,
    val type: String?,
    val rating: String?,
    val giphyUrl: String?
)
