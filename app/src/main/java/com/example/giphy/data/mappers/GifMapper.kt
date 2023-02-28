package com.example.giphy.data.mappers

import com.example.giphy.data.network.model.GifDto
import com.example.giphy.data.network.model.GifListDto
import com.example.giphy.domain.entity.Gif
import javax.inject.Inject

class GifMapper @Inject constructor() {

    fun mapListDtoToListEntity(dto: GifListDto): List<Gif> {
        return dto.gifList.map {
            mapDtoToEntity(it)
        }
    }

    fun mapDtoToEntity(dto: GifDto) = Gif(
        dto.imageDto.originImageDto.url,
        dto.type,
        dto.rating,
        dto.giphyUrl
    )
}