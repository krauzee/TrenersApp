package com.krauzze.trenersapp.data.gateway

import com.krauzze.trenersapp.data.network.mapper.TrenersRequestMapper
import com.krauzze.trenersapp.data.source.TrenersLoader
import com.krauzze.trenersapp.domain.entity.TrenerEntity
import com.krauzze.trenersapp.domain.gateway.TrenersGateway
import io.reactivex.Observable
import javax.inject.Inject

class TrenersGatewayImpl @Inject constructor() : TrenersGateway  {

    @Inject
    lateinit var loader: TrenersLoader

    override fun getTreners(): Observable<TrenerEntity> {
        return loader.getTreners()
            .flatMapObservable {
            Observable.fromIterable(it)
        }
            .map(TrenersRequestMapper())
    }
}