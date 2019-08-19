package com.krauzze.trenersapp.presentation.base

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface FragmentMvpInterface: BaseView {
    companion object {
        val DIALOG_TYPE_INFO = 0
        val DIALOG_TYPE_ERROR = 1
    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun hideContentAndParallax()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showContentAndParallax()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun hideContent()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showContent()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showBackground()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun hideBackground()
    
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorDialog(title: String,  message: String,action: () -> Unit, canceleble: Boolean = false)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorDialog(title: Int,  message: Int,action: () -> Unit, canceleble: Boolean = false)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProgress()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun hideProgress()
}