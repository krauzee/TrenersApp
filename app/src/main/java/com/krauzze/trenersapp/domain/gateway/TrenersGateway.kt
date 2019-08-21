package com.krauzze.trenersapp.domain.gateway

import com.krauzze.trenersapp.domain.entity.TrenerEntity
import io.reactivex.Observable

interface TrenersGateway {
    fun getTreners(): Observable<TrenerEntity>
}