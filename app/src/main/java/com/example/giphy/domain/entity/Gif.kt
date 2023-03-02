package com.example.giphy.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class Gif @Inject constructor(
    val imageUrl: String?,
    val type: String?,
    val rating: String?,
    val giphyUrl: String?,
    val id: String?
): Parcelable
