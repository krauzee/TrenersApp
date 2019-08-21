package com.krauzze.trenersapp.data.network.mapper

import android.media.Image
import com.krauzze.trenersapp.data.network.pojo.TrenerRequest
import com.krauzze.trenersapp.domain.entity.TrenerEntity
import io.reactivex.functions.Function

class TrenersRequestMapper : Function<TrenerRequest, TrenerEntity> {
    override fun apply(t: TrenerRequest): TrenerEntity {
        return TrenerEntity(
            t.image?: "",
            t.name ?: "",
            t.ampl ?: "",
            t.price ?: ""
        )
    }
}