package com.example.giphy.data.network.model

import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("original") val originImageDto: OriginalImageDto
)
