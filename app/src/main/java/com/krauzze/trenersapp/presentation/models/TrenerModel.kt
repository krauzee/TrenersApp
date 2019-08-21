package com.krauzze.trenersapp.presentation.models

import com.krauzze.trenersapp.domain.entity.TrenerEntity

data class TrenerModel(
    val image: String,
    val name: String,
    val ampl: String,
    val price: String
)

object TrenerModelMapper {
    fun map(account: TrenerEntity): TrenerModel {
        return account.run {
            TrenerModel(
                this.img,
                this.name,
                this.ampl,
                this.price
            )
        }
    }
}