package com.example.giphy.data.network.model

import com.google.gson.annotations.SerializedName

data class OriginalImageDto(
    @SerializedName("url") val url: String
)
