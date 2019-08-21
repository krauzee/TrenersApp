package com.krauzze.trenersapp.domain.mappers

import com.krauzze.trenersapp.data.dto.TrenersDto
import com.krauzze.trenersapp.domain.entity.TrenerEntity

object TrenersDtoMapper {

    fun map(trenerEntity: TrenerEntity): TrenersDto {
        return TrenersDto(trenerEntity)
    }
}