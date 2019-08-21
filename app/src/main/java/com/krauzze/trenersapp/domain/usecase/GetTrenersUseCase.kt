package com.krauzze.trenersapp.domain.usecase

import com.krauzze.trenersapp.data.dto.TrenersDto
import com.krauzze.trenersapp.domain.gateway.TrenersGateway
import com.krauzze.trenersapp.domain.mappers.TrenersDtoMapper
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetTrenersUseCase @Inject constructor(private val trenersGateway: TrenersGateway) {

    fun getTreners(): Observable<TrenersDto> {
        return trenersGateway.getTreners().map(TrenersDtoMapper::map)
    }
}