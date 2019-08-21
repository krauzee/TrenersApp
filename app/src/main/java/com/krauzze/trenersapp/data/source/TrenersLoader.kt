package com.krauzze.trenersapp.data.source

import com.krauzze.trenersapp.data.network.pojo.TrenerRequest
import io.reactivex.Single

interface TrenersLoader {

    fun getTreners(): Single<List<TrenerRequest>>
}