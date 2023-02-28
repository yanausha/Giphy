package com.example.giphy.data.network.model

import com.google.gson.annotations.SerializedName

data class GifDto(
    @SerializedName("images") val imageDto: ImageDto,
    @SerializedName("type") val type: String?,
    @SerializedName("rating") val rating: String?,
    @SerializedName("url") val giphyUrl: String?,
    @SerializedName("id") val id: String?
)
