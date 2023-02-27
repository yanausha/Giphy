package com.example.giphy.data.network.model

import com.google.gson.annotations.SerializedName

data class GifListDto(
    @SerializedName("data") val gifList: List<GifDto>
)
