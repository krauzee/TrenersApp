package com.krauzze.trenersapp.presentation.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface BaseView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showSnackbar(text: String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showSnackbar(text: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showErrorSnackbar(error: String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showErrorSnackbar(error: Int)


}