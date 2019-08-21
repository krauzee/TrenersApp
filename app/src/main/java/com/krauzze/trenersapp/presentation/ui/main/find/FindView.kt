package com.krauzze.trenersapp.presentation.ui.main.find

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.krauzze.trenersapp.domain.entity.TrenerEntity
import com.krauzze.trenersapp.presentation.base.FragmentMvpInterface
import com.krauzze.trenersapp.presentation.models.TrenerModel

interface FindView : FragmentMvpInterface {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setTreners(treners: List<TrenerModel>)
}